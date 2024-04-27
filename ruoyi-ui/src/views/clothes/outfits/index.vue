<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="帽子id" prop="topsId">
        <el-input
          v-model="queryParams.topsId"
          placeholder="请输入帽子id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上衣id" prop="hatsId">
        <el-input
          v-model="queryParams.hatsId"
          placeholder="请输入上衣id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="裤子id" prop="pantsId">
        <el-input
          v-model="queryParams.pantsId"
          placeholder="请输入裤子id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="鞋子id" prop="shoesId">
        <el-input
          v-model="queryParams.shoesId"
          placeholder="请输入鞋子id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="装饰id" prop="ornamentId">
        <el-input
          v-model="queryParams.ornamentId"
          placeholder="请输入装饰id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户id" prop="usersId">
        <el-input
          v-model="queryParams.usersId"
          placeholder="请输入用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="搭配名称" prop="outfitsName">
        <el-input
          v-model="queryParams.outfitsName"
          placeholder="请输入搭配名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['clothes:outfits:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['clothes:outfits:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['clothes:outfits:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['clothes:outfits:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="outfitsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="搭配id" align="center" prop="outfitsId" />
      <el-table-column label="帽子id" align="center" prop="topsId" />
      <el-table-column label="上衣id" align="center" prop="hatsId" />
      <el-table-column label="裤子id" align="center" prop="pantsId" />
      <el-table-column label="鞋子id" align="center" prop="shoesId" />
      <el-table-column label="装饰id" align="center" prop="ornamentId" />
      <el-table-column label="用户id" align="center" prop="usersId" />
      <el-table-column label="搭配名称" align="center" prop="outfitsName" />
      <el-table-column label="搭配图" align="center" prop="outfitsImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.outfitsImage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['clothes:outfits:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['clothes:outfits:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改搭配管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="帽子id" prop="topsId">
          <el-input v-model="form.topsId" placeholder="请输入帽子id" />
        </el-form-item>
        <el-form-item label="上衣id" prop="hatsId">
          <el-input v-model="form.hatsId" placeholder="请输入上衣id" />
        </el-form-item>
        <el-form-item label="裤子id" prop="pantsId">
          <el-input v-model="form.pantsId" placeholder="请输入裤子id" />
        </el-form-item>
        <el-form-item label="鞋子id" prop="shoesId">
          <el-input v-model="form.shoesId" placeholder="请输入鞋子id" />
        </el-form-item>
        <el-form-item label="装饰id" prop="ornamentId">
          <el-input v-model="form.ornamentId" placeholder="请输入装饰id" />
        </el-form-item>
        <el-form-item label="用户id" prop="usersId">
          <el-input v-model="form.usersId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="搭配名称" prop="outfitsName">
          <el-input v-model="form.outfitsName" placeholder="请输入搭配名称" />
        </el-form-item>
        <el-form-item label="搭配图" prop="outfitsImage">
          <image-upload v-model="form.outfitsImage"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOutfits, getOutfits, delOutfits, addOutfits, updateOutfits } from "@/api/clothes/outfits";

export default {
  name: "Outfits",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 搭配管理表格数据
      outfitsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        topsId: null,
        hatsId: null,
        pantsId: null,
        shoesId: null,
        ornamentId: null,
        usersId: null,
        outfitsName: null,
        outfitsImage: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询搭配管理列表 */
    getList() {
      this.loading = true;
      listOutfits(this.queryParams).then(response => {
        this.outfitsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        outfitsId: null,
        topsId: null,
        hatsId: null,
        pantsId: null,
        shoesId: null,
        ornamentId: null,
        usersId: null,
        outfitsName: null,
        outfitsImage: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.outfitsId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加搭配管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const outfitsId = row.outfitsId || this.ids
      getOutfits(outfitsId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改搭配管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.outfitsId != null) {
            updateOutfits(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOutfits(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const outfitsIds = row.outfitsId || this.ids;
      this.$modal.confirm('是否确认删除搭配管理编号为"' + outfitsIds + '"的数据项？').then(function() {
        return delOutfits(outfitsIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('clothes/outfits/export', {
        ...this.queryParams
      }, `outfits_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
