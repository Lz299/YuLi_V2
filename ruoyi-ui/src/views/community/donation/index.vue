<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户id" prop="usersId">
        <el-input
          v-model="queryParams.usersId"
          placeholder="请输入用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="捐赠衣服" prop="clothes">
        <el-input
          v-model="queryParams.clothes"
          placeholder="请输入捐赠衣服"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="送货地址" prop="donationAddress">
        <el-input
          v-model="queryParams.donationAddress"
          placeholder="请输入送货地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户地址" prop="usersAddress">
        <el-input
          v-model="queryParams.usersAddress"
          placeholder="请输入用户地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预约时间" prop="bookingTime">
        <el-date-picker clearable
          v-model="queryParams.bookingTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预约时间">
        </el-date-picker>
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
          v-hasPermi="['community:donation:add']"
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
          v-hasPermi="['community:donation:edit']"
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
          v-hasPermi="['community:donation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['community:donation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="donationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="捐赠id" align="center" prop="donationId" />
      <el-table-column label="用户id" align="center" prop="usersId" />
      <el-table-column label="捐赠衣服" align="center" prop="clothes" />
      <el-table-column label="送货地址" align="center" prop="donationAddress" />
      <el-table-column label="用户地址" align="center" prop="usersAddress" />
      <el-table-column label="预约时间" align="center" prop="bookingTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.bookingTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['community:donation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['community:donation:remove']"
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

    <!-- 添加或修改捐赠管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="usersId">
          <el-input v-model="form.usersId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="捐赠衣服" prop="clothes">
          <el-input v-model="form.clothes" placeholder="请输入捐赠衣服" />
        </el-form-item>
        <el-form-item label="送货地址" prop="donationAddress">
          <el-input v-model="form.donationAddress" placeholder="请输入送货地址" />
        </el-form-item>
        <el-form-item label="用户地址" prop="usersAddress">
          <el-input v-model="form.usersAddress" placeholder="请输入用户地址" />
        </el-form-item>
        <el-form-item label="预约时间" prop="bookingTime">
          <el-date-picker clearable
            v-model="form.bookingTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预约时间">
          </el-date-picker>
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
import { listDonation, getDonation, delDonation, addDonation, updateDonation } from "@/api/community/donation";

export default {
  name: "Donation",
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
      // 捐赠管理表格数据
      donationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        usersId: null,
        clothes: null,
        donationAddress: null,
        usersAddress: null,
        bookingTime: null
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
    /** 查询捐赠管理列表 */
    getList() {
      this.loading = true;
      listDonation(this.queryParams).then(response => {
        this.donationList = response.rows;
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
        donationId: null,
        usersId: null,
        clothes: null,
        donationAddress: null,
        usersAddress: null,
        bookingTime: null
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
      this.ids = selection.map(item => item.donationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加捐赠管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const donationId = row.donationId || this.ids
      getDonation(donationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改捐赠管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.donationId != null) {
            updateDonation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDonation(this.form).then(response => {
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
      const donationIds = row.donationId || this.ids;
      this.$modal.confirm('是否确认删除捐赠管理编号为"' + donationIds + '"的数据项？').then(function() {
        return delDonation(donationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('community/donation/export', {
        ...this.queryParams
      }, `donation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
