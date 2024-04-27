<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身高" prop="height">
        <el-input
          v-model="queryParams.height"
          placeholder="请输入身高"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体重 " prop="weight">
        <el-input
          v-model="queryParams.weight"
          placeholder="请输入体重 "
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="腰围" prop="waistline">
        <el-input
          v-model="queryParams.waistline"
          placeholder="请输入腰围"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="胸围" prop="bust">
        <el-input
          v-model="queryParams.bust"
          placeholder="请输入胸围"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="臀围" prop="hips">
        <el-input
          v-model="queryParams.hips"
          placeholder="请输入臀围"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="肩宽" prop="shoulderWidth">
        <el-input
          v-model="queryParams.shoulderWidth"
          placeholder="请输入肩宽"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="臂长" prop="armLength">
        <el-input
          v-model="queryParams.armLength"
          placeholder="请输入臂长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="腿长" prop="legLength">
        <el-input
          v-model="queryParams.legLength"
          placeholder="请输入腿长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身材比" prop="bodyProportions">
        <el-input
          v-model="queryParams.bodyProportions"
          placeholder="请输入身材比"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="肤色" prop="complexion">
        <el-input
          v-model="queryParams.complexion"
          placeholder="请输入肤色"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="穿着习惯" prop="dressHabits">
        <el-input
          v-model="queryParams.dressHabits"
          placeholder="请输入穿着习惯"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="特殊需求" prop="specialNeeds">
        <el-input
          v-model="queryParams.specialNeeds"
          placeholder="请输入特殊需求"
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
          v-hasPermi="['users:stature:add']"
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
          v-hasPermi="['users:stature:edit']"
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
          v-hasPermi="['users:stature:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['users:stature:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="statureList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="身材id" align="center" prop="statureId" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="身高" align="center" prop="height" />
      <el-table-column label="体重 " align="center" prop="weight" />
      <el-table-column label="腰围" align="center" prop="waistline" />
      <el-table-column label="胸围" align="center" prop="bust" />
      <el-table-column label="臀围" align="center" prop="hips" />
      <el-table-column label="肩宽" align="center" prop="shoulderWidth" />
      <el-table-column label="臂长" align="center" prop="armLength" />
      <el-table-column label="腿长" align="center" prop="legLength" />
      <el-table-column label="身材比" align="center" prop="bodyProportions" />
      <el-table-column label="体型" align="center" prop="somatotype" />
      <el-table-column label="肤色" align="center" prop="complexion" />
      <el-table-column label="穿着习惯" align="center" prop="dressHabits" />
      <el-table-column label="特殊需求" align="center" prop="specialNeeds" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['users:stature:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['users:stature:remove']"
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

    <!-- 添加或修改身材管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="身高" prop="height">
          <el-input v-model="form.height" placeholder="请输入身高" />
        </el-form-item>
        <el-form-item label="体重 " prop="weight">
          <el-input v-model="form.weight" placeholder="请输入体重 " />
        </el-form-item>
        <el-form-item label="腰围" prop="waistline">
          <el-input v-model="form.waistline" placeholder="请输入腰围" />
        </el-form-item>
        <el-form-item label="胸围" prop="bust">
          <el-input v-model="form.bust" placeholder="请输入胸围" />
        </el-form-item>
        <el-form-item label="臀围" prop="hips">
          <el-input v-model="form.hips" placeholder="请输入臀围" />
        </el-form-item>
        <el-form-item label="肩宽" prop="shoulderWidth">
          <el-input v-model="form.shoulderWidth" placeholder="请输入肩宽" />
        </el-form-item>
        <el-form-item label="臂长" prop="armLength">
          <el-input v-model="form.armLength" placeholder="请输入臂长" />
        </el-form-item>
        <el-form-item label="腿长" prop="legLength">
          <el-input v-model="form.legLength" placeholder="请输入腿长" />
        </el-form-item>
        <el-form-item label="身材比" prop="bodyProportions">
          <el-input v-model="form.bodyProportions" placeholder="请输入身材比" />
        </el-form-item>
        <el-form-item label="肤色" prop="complexion">
          <el-input v-model="form.complexion" placeholder="请输入肤色" />
        </el-form-item>
        <el-form-item label="穿着习惯" prop="dressHabits">
          <el-input v-model="form.dressHabits" placeholder="请输入穿着习惯" />
        </el-form-item>
        <el-form-item label="特殊需求" prop="specialNeeds">
          <el-input v-model="form.specialNeeds" placeholder="请输入特殊需求" />
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
import { listStature, getStature, delStature, addStature, updateStature } from "@/api/users/stature";

export default {
  name: "Stature",
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
      // 身材管理表格数据
      statureList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        age: null,
        height: null,
        weight: null,
        waistline: null,
        bust: null,
        hips: null,
        shoulderWidth: null,
        armLength: null,
        legLength: null,
        bodyProportions: null,
        somatotype: null,
        complexion: null,
        dressHabits: null,
        specialNeeds: null,
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
    /** 查询身材管理列表 */
    getList() {
      this.loading = true;
      listStature(this.queryParams).then(response => {
        this.statureList = response.rows;
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
        statureId: null,
        age: null,
        height: null,
        weight: null,
        waistline: null,
        bust: null,
        hips: null,
        shoulderWidth: null,
        armLength: null,
        legLength: null,
        bodyProportions: null,
        somatotype: null,
        complexion: null,
        dressHabits: null,
        specialNeeds: null,
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
      this.ids = selection.map(item => item.statureId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加身材管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const statureId = row.statureId || this.ids
      getStature(statureId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改身材管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.statureId != null) {
            updateStature(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStature(this.form).then(response => {
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
      const statureIds = row.statureId || this.ids;
      this.$modal.confirm('是否确认删除身材管理编号为"' + statureIds + '"的数据项？').then(function() {
        return delStature(statureIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('users/stature/export', {
        ...this.queryParams
      }, `stature_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
