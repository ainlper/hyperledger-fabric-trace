<template >

  <div >
    <el-header style="text-align: right;text-align: center; font-size: 12px;margin-bottom: 30px;background-color:#69b3f0;" class="back">
      <h1 style="color: navajowhite">食品溯源系统</h1>
    </el-header>

    <el-form ref="form" :model="form" label-width="100px">
      <el-form-item label="请输入溯源id">
        <el-input v-model="form.traceability_id" ></el-input>
      </el-form-item>
      <el-form-item id="cen">
        <el-button type="primary" @click="foodtrace()" >查询</el-button>
        <el-button type="primary" @click="back()" >返回</el-button>
      </el-form-item>
    </el-form>
    <el-table
        ref="filterTable"
        :data="tableData"
        stripe
        style="width: 100%">
      <el-table-column
          prop="txid"
          label="TxId"
          width="188">
      </el-table-column>
      <el-table-column
          prop="timestamp"
          label="Timestamp"
          width="180">
      </el-table-column>
      <el-table-column
          prop="traceability_id"
          label="溯源id"
          width="80">
      </el-table-column>
      <el-table-column
          prop="name"
          label="商品名称"
          width="80">
      </el-table-column>
      <el-table-column
          prop="date_of_manufacture"
          label="生产日期"
          width="80">
      </el-table-column>
      <el-table-column
          prop="manufactor"
          label="生产厂家"
          width="80">
      </el-table-column>
      <el-table-column
          prop="telephone"
          label="厂家电话"
          width="80">
      </el-table-column>
      <el-table-column
          prop="listing_date"
          label="上架日期"
          width="80">
      </el-table-column>
      <el-table-column
          prop="courier_number"
          label="快递单号"
          width="80">
      </el-table-column>
      <el-table-column
          prop="term_of_validity"
          label="有效期"
          width="80">
      </el-table-column>
      <el-table-column
          prop="company"
          label="公司名称"
          width="80">
      </el-table-column>
      <el-table-column
          prop="tel"
          label="公司电话"
          width="95">
      </el-table-column>
      <el-table-column
          prop="delivery_date"
          label="快递日期"
          width="80">
      </el-table-column>


    </el-table>



<!--    <el-pagination-->
<!--        background-->
<!--        layout="prev, pager, next"-->
<!--        page-size="4"-->
<!--        :total="total"-->
<!--        @current-change="page"-->
<!--        style="width: 900px"-->
<!--        class="page">-->
<!--    </el-pagination>-->
  </div>

</template>

<script>


export default {

  methods: {
    showFood(row){
      const _this = this
      axios.get('http://localhost:8181/fabric/findById/'+row.id).then(function (resp){
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
              _this.$router.push('/pagethree')
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
    back(){
      this.$router.push('/zzz')
    },
    foodtrace(){

      const _this = this



      axios.get('http://localhost:8181/fabric/findById/'+this.form.traceability_id).then(function (resp){
        var traceability_id1 = null ;         //溯源id
        var name1 = null  ;                    //商品名称
        var date_of_manufacture1= null  ;     //生产日期
        var manufactor1 = null  ;              //生产厂家
        var telephone1  = null ;               //生产厂家电话

        var listing_date1 = null  ;            //上架日期
        var courier_number1  = null ;          //快递单号
        var term_of_validity1 = null  ;        //有效期
        var company1 = null  ;                 //公司名称
        var tel1 = null  ;                     //公司电话
        var delivery_date1 = null  ;           //快递日期
        var txid1  ;                     //txid
        var timestamp1  ;                //时间戳
        for (var item1 in resp.data) {
          var property1 = "";
          property1 += "属性：" + item1 + "数值：" + resp.data[item1] + "\n";
          // alert(property1)
          for (var item2 in resp.data[item1]) {
            var property2 = "";
            property2 += "属性：" + item2 + "数值：" + resp.data[item1][item2] + "\n";
            // alert(property2)
            for (var item3 in resp.data[item1][item2]) {
              var property3 = "";
              property3 += "属性：" + item3 + "数值：" + resp.data[item1][item2][item3] + "\n";
              // alert(property3)
              if (item3 == "TxId"){
                txid1 = resp.data[item1][item2][item3]
              }if (item3 == "Timestamp"){
                timestamp1 = resp.data[item1][item2][item3]
              }if (item3 == "Value"){
                for (var item4 in resp.data[item1][item2][item3]) {
                  var property4 = "";
                  property4 += "属性：" + item4 + "数值：" + resp.data[item1][item2][item3][item4] + "\n";
                  // alert(property4)
                  if (item4 == "traceability_id"){
                    traceability_id1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "name"){
                    name1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "date_of_manufacture"){
                    date_of_manufacture1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "manufactor"){
                    manufactor1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "telephone"){
                    telephone1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "listing_date"){
                    listing_date1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "courier_number"){
                    courier_number1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "term_of_validity"){
                    term_of_validity1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "company"){
                    company1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "tel"){
                    tel1 = resp.data[item1][item2][item3][item4]
                  }if (item4 == "delivery_date"){
                    delivery_date1 = resp.data[item1][item2][item3][item4]
                  }

                }
                _this.tableData[item2].txid=txid1
                _this.tableData[item2].timestamp=timestamp1
                _this.tableData[item2].traceability_id=traceability_id1
                _this.tableData[item2].name=name1
                _this.tableData[item2].date_of_manufacture=date_of_manufacture1
                _this.tableData[item2].manufactor=manufactor1
                _this.tableData[item2].telephone=telephone1
                _this.tableData[item2].listing_date=listing_date1
                _this.tableData[item2].courier_number=courier_number1
                _this.tableData[item2].term_of_validity=term_of_validity1
                _this.tableData[item2].company=company1
                _this.tableData[item2].tel=tel1
                _this.tableData[item2].delivery_date=delivery_date1
              }

            }

          }
        }

      })
    },
    // page(currentPage){
    //   const _this = this
    //   axios.get('http://localhost:8181/fabric/findAll/'+currentPage+'/4').then(function (resp){
    //     _this.tableData = resp.data.content
    //     _this.total = resp.data.totalElements
    //   })
    //
    // }
  },
  created(){
    // alert(this.GLOBAL.table_index)

    // const _this = this
    // axios.get("http://localhost:8181/fabric/findAll/1/4").then(function (resp){
    //   _this.tableData = resp.data.content
    //   _this.total = resp.data.totalElements
    // })

  },

  data() {
    return {
      total:null,
      tableData: [{
        txid:null,
        name:null,
        traceability_id:null,
        timestamp:null,
        date_of_manufacture:null,
        manufactor:null,
        telephone:null,
        listing_date:null,
        courier_number:null,
        term_of_validity:null,
        company:null,
        tel:null,
        delivery_date:null,
      },{
        txid:null,
        name:null,
        traceability_id:null,
        timestamp:null,
        date_of_manufacture:null,
        manufactor:null,
        telephone:null,
        listing_date:null,
        courier_number:null,
        term_of_validity:null,
        company:null,
        tel:null,
        delivery_date:null,
      },{
        txid:null,
        name:null,
        traceability_id:null,
        timestamp:null,
        date_of_manufacture:null,
        manufactor:null,
        telephone:null,
        listing_date:null,
        courier_number:null,
        term_of_validity:null,
        company:null,
        tel:null,
        delivery_date:null,
      }],
      dialogFormVisible: false,
      form: {
        traceability_id:'',
      },
      formLabelWidth: '80px',
    }
  },

}
</script>
<style>
#go{
  margin-top: 0px;
  margin-left: 46%;
}
</style>
<style>

#cen{
  margin-left: 36.5%;
}
#app{
  overflow:hidden!important;
}
</style>