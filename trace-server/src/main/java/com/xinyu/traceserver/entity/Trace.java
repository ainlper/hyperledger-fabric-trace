package com.xinyu.traceserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Trace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String traceability_id;     //溯源id
    private String name;                //商品名称
    private String date_of_manufacture; //生产日期
    private String manufactor;          //生产厂家
    private String telephone;           //生产厂家电话

    private String listing_date;        //上架日期
    private String courier_number;      //快递单号
    private String term_of_validity;    //有效期
    private String company;             //公司名称
    private String tel;                 //公司电话
    private String delivery_date;       //快递日期
}
