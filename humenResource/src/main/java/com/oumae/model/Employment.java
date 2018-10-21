package com.oumae.model;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

/**
 * Created by oumaereina on 2018/10/21.
 */
/*招聘信息*/
public class Employment {
    private Integer EM_ID;
    private String EM_COMPANY;//公司
    private String EM_POST;//岗位
    private Integer EM_PEOPLE;//人数
    private String EM_ADD;//工作地点
    private String EM_EDU;//学历要求
    private Integer EM_SALARY;//薪资
    private String EM_EXP;//经验要求
    private Date EM_DATE;//发布日期

    public Employment(String EM_COMPANY, String EM_POST, Integer EM_PEOPLE, String EM_ADD, String EM_EDU, Integer EM_SALARY, String EM_EXP, Date EM_DATE) {
        this.EM_COMPANY = EM_COMPANY;
        this.EM_POST = EM_POST;
        this.EM_PEOPLE = EM_PEOPLE;
        this.EM_ADD = EM_ADD;
        this.EM_EDU = EM_EDU;
        this.EM_SALARY = EM_SALARY;
        this.EM_EXP = EM_EXP;
        this.EM_DATE = EM_DATE;
    }

    public Employment() {
    }

    public Integer getEM_ID() {
        return EM_ID;
    }

    public void setEM_ID(Integer EM_ID) {
        this.EM_ID = EM_ID;
    }

    public String getEM_COMPANY() {
        return EM_COMPANY;
    }

    public void setEM_COMPANY(String EM_COMPANY) {
        this.EM_COMPANY = EM_COMPANY;
    }

    public String getEM_POST() {
        return EM_POST;
    }

    public void setEM_POST(String EM_POST) {
        this.EM_POST = EM_POST;
    }

    public Integer getEM_PEOPLE() {
        return EM_PEOPLE;
    }

    public void setEM_PEOPLE(Integer EM_PEOPLE) {
        this.EM_PEOPLE = EM_PEOPLE;
    }

    public String getEM_ADD() {
        return EM_ADD;
    }

    public void setEM_ADD(String EM_ADD) {
        this.EM_ADD = EM_ADD;
    }

    public String getEM_EDU() {
        return EM_EDU;
    }

    public void setEM_EDU(String EM_EDU) {
        this.EM_EDU = EM_EDU;
    }

    public Integer getEM_SALARY() {
        return EM_SALARY;
    }

    public void setEM_SALARY(Integer EM_SALARY) {
        this.EM_SALARY = EM_SALARY;
    }

    public String getEM_EXP() {
        return EM_EXP;
    }

    public void setEM_EXP(String EM_EXP) {
        this.EM_EXP = EM_EXP;
    }

    public Date getEM_DATE() {
        return EM_DATE;
    }

    public void setEM_DATE(Date EM_DATE) {
        this.EM_DATE = EM_DATE;
    }
}
