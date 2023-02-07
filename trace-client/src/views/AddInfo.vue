<template>
  <el-form style="width: 97%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="溯源id" prop="traceability_id">
      <el-input v-model="ruleForm.traceability_id"></el-input>
    </el-form-item>
    <el-form-item label="食品名称" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="生产日期" prop="date_of_manufacture">
      <el-input v-model="ruleForm.date_of_manufacture"></el-input>
    </el-form-item>
    <el-form-item label="生产厂家" prop="manufactor">
      <el-input v-model="ruleForm.manufactor"></el-input>
    </el-form-item>
    <el-form-item label="厂家电话" prop="telephone">
      <el-input v-model="ruleForm.telephone"></el-input>
    </el-form-item>


    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>

  </el-form>
</template>


<script>
export default {
  data() {
    return {
      ruleForm: {
        traceability_id: '',
        name: '',
        date_of_manufacture: '',
        manufactor: '',
        telephone: ''

      },
      rules: {
        traceability_id: [
          { required: true, message: '溯源id不能为空', trigger: 'blur' },
        ],
        name: [
          { required: true, message: '食品名称不能为空', trigger: 'blur' },
        ],
        date_of_manufacture: [
          { required: true, message: '生产日期不能为空', trigger: 'blur' },
        ],
        manufactor: [
          { required: true, message: '厂家名称不能为空', trigger: 'blur' },
        ],
        telephone: [
          { required: true, message: '厂家电话不能为空', trigger: 'blur' },
        ],
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post("http://localhost:8181/fabric/save",this.ruleForm).then(function (resp){
            if(resp.data == 'success'){
              _this.$alert(_this.ruleForm.name+'添加成功！', 'status:200', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/Food_manufacturers')
                }
              })
            }else{
              _this.$alert(_this.ruleForm.name+'添加失败！', 'status:400', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/AddFood')
                }
              })
            }

          })

        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>
<style>

</style>