package com.xinyu.traceserver.controller;

import java.util.Arrays;

public class pin {
    public static void main(String[] args) {
        String traceability_id = "555";         //溯源id
        String name = "老八秘制小汉堡";    //商品名称
        String date_of_manufacture = "2022/8/5";     //生产日期
        String manufactor = "米奇妙妙屋";       //生产厂家
        String telephone = "12345678910";  //生产厂家电话

        String listing_date = "2022/8/11";     //上架日期
        String courier_number = "123";          //快递单号
        String term_of_validity = "8个月";          //有效期
        String company = "芜湖起飞";         //公司名称
        String tel = "12345678910";  //公司电话
        String delivery_date = "2022/8/5";     //快递日期
        Integer id = 43;
//        String hhh[] ={'"'+id+'"'};


        String str = Integer.toString(id);
        String hhh[] = {'"' + str + '"'};
        System.out.println(hhh);

        String initArgs[] = {"555", "{\"traceability_id\":\"555\",\"name\":\"老八秘制小汉堡\",\"date_of_manufacture\":\"2022/8/5\",\"manufactor\":\"米奇妙妙屋\",\"telephone\":\"12345678910\",\"listing_date\":\"2022/8/11\",\"courier_number\":\"123\",\"term_of_validity\":\"8个月\",\"company\":\"芜湖起飞\",\"tel\":\"12345678910\",\"delivery_date\":\"2022/8/5\"}"};

        String initArgs2[] = {traceability_id + "," + "{" + '"' + "traceability_id" + '"' + ":" + '"' + traceability_id + '"' + "," + "\"name" + '"' + ":" + '"' + name + '"' + "," + "\"date_of_manufacture" + '"' + ":" + '"' + date_of_manufacture + '"' + "," + "\"manufactor" + '"' + ":" + '"' + manufactor + '"' + "," + "\"telephone" + '"' + ":" + '"' + telephone + '"' + "," + "\"listing_date" + '"' + ":" + '"' + listing_date + '"' + "," + "\"courier_number" + '"' + ":" + '"' + courier_number + '"' + "," + "\"term_of_validity" + '"' + ":" + '"' + term_of_validity + '"' + "," + "\"company" + '"' + ":" + '"' + company + '"' + "," + "\"tel" + '"' + ":" + '"' + tel + '"' + "," + "\"delivery_date" + '"' + ":" + '"' + delivery_date + '"' + "}"};

        String tt[] = {'"' + "Args" + '"' + "," + "\"initMarble\",\"marbles9\",\"bule\",\"35\",\"tom\""};

//        System.out.println(Arrays.toString(initArgs));
//        System.out.println(Arrays.toString(initArgs2));
//        System.out.println(Arrays.toString(hhh));
        System.out.println(Arrays.toString(tt));

    }
}
