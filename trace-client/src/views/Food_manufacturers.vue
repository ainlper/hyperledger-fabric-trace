<template>
  <div>
    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          fixed
          prop="id"
          label="数据编号"
          width="135">
      </el-table-column>

      <el-table-column
          prop="traceability_id"
          label="溯源id"
          width="150">
      </el-table-column>
      <el-table-column
          prop="name"
          label="食品名称"
          width="150">
      </el-table-column>
      <el-table-column
          prop="date_of_manufacture"
          label="生产日期"
          width="150">
      </el-table-column>
      <el-table-column
          prop="manufactor"
          label="生产厂家"
          width="150">
      </el-table-column>
      <el-table-column
        prop="telephone"
        label="厂家电话"
        width="150">
    </el-table-column>


      <el-table-column

          label="操作"
          width="150">

        <template slot-scope="scope">
          <el-button @click="showFood(scope.row);dialogFormVisible = true;"   type="text" size="small" >修改</el-button>
          <el-button @click="deleteFood(scope.row)" type="text" size="small">删除</el-button>
        </template>


      </el-table-column>
    </el-table>

    <el-dialog title="信息变更" :visible.sync="dialogFormVisible" style="height: 100%!important;text-align: center" >
      <el-form :model="form" id="xg" style="width: 97%;height: 30%!important;margin-top: 0px" label-width="100px" >
        <el-form-item label="数据编号" :label-width="formLabelWidth" >
          <el-input v-model="form.id" autocomplete="off" placeholder="编号" readonly></el-input>
        </el-form-item>
        <el-form-item label="食品名称" :label-width="formLabelWidth" >
          <el-input v-model="form.name" autocomplete="off" placeholder="请输入变更后食品名称"></el-input>
        </el-form-item>
        <el-form-item label="生产日期" :label-width="formLabelWidth" >
          <el-input v-model="form.date_of_manufacture" autocomplete="off" placeholder="请输入变更后生产日期"></el-input>
        </el-form-item>
        <el-form-item label="生产厂家" :label-width="formLabelWidth" >
          <el-input v-model="form.manufactor" autocomplete="off" placeholder="请输入变更后生产厂家"></el-input>
        </el-form-item>
        <el-form-item label="厂家电话" :label-width="formLabelWidth" >
          <el-input v-model="form.telephone" autocomplete="off" placeholder="请输入变更后厂家电话"></el-input>
        </el-form-item>
      </el-form >
      <div slot="footer" class="dialog-footer" style="width: 62% ;" >
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false;edit(form);">确 定</el-button>
      </div>
    </el-dialog>


    <el-pagination
        background
        layout="prev, pager, next"
        page-size="6"
        :total="total"
        @current-change="page"
        style="width: 900px"
        id="page">
    </el-pagination>
  </div>

</template>

<script>

export default {

  methods: {
    showFood(row){
      const _this = this
      axios.get('http://localhost:8181/fabric/findproById/'+row.id).then(function (resp){
        _this.form = resp.data
      })

    },
    deleteFood(row){

      const _this = this
      axios.delete('http://localhost:8181/fabric/deleteById/'+row.id).then(function (resp){
        if(resp.status == '200'){
          _this.$alert('《'+row.name+'》删除成功！', 'status:200', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload()
            }
          })
        }else{
          _this.$alert('《'+row.name+'》删除失败！', 'status:400', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload()
            }
          })
        }
      })
    },
    edit(form) {
      const _this = this

      axios.put("http://localhost:8181/fabric/updata",this.form).then(function (resp){
        if(resp.data == 'success'){
          _this.$alert(_this.form.name+'修改成功！', 'status:200', {
            confirmButtonText: '确定',
            callback: action => {
              _this.$router.push('/Food_manufacturers')
            }
          })
        }else{
          _this.$alert(_this.form.name+'修改失败！', 'status:400', {
            confirmButtonText: '确定',
            callback: action => {
              _this.$router.push('/edit')
            }
          })
        }

      })
    },

    page(currentPage){
      const _this = this
      axios.get('http://localhost:8181/fabric/findAll/'+currentPage+'/6').then(function (resp){
        _this.tableData = resp.data.content
        _this.total = resp.data.totalElements
      })

    }
  },
  created(){
    const _this = this
    axios.get("http://localhost:8181/fabric/findAll/1/6").then(function (resp){
      _this.tableData = resp.data.content
      _this.total = resp.data.totalElements
    })


  },

  data() {
    return {
      total:null,
      tableData: null,
      dialogFormVisible: false,
      form: {
        id:'',
        name: '',
        date_of_manufacture: '',
        manufactor: '',
        telephone: '',
      },
      formLabelWidth: '80px'
    }
  },

}
</script>
<style>

#page{
  margin-left: 25%!important;
  margin-top: 13px;
}

div.el-dialog__wrapper{
  width: 100%;
  height: 100%;
  /*overflow: hidden;*/

}
div.el-dialog__header{
  margin-top: 2%;
  padding-top: 10px!important;
  margin-bottom: 15px;

}
div.el-dialog__body{
  margin-top: -40px;
  padding-top: -15px!important;
  padding-bottom: -15px!important;
}
div.el-form-item{
  margin-bottom: 8px;
}
div.el-dialog__footer{
  margin-top: -40px;
  padding-top: -15px!important;
  padding-bottom: -15px!important;
  margin-bottom: 0%;
}
</style>