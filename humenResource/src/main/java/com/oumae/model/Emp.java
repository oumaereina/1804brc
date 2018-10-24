package com.oumae.model;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by oumaereina on 2018/10/22.
 */
/*员工*/
public class Emp {
    private Integer e_id;
    private String e_name;
    private String e_pass;
    private Integer e_p_id;/*岗位*/
    private String e_mail;
    private BigInteger e_phone;
    private Integer e_d_id;/*部门*/
    private String e_realName;
    private Double e_salary;
    private String e_sex;
    private Integer e_state;
    private Integer e_age;
    private Date e_date;
    public Emp() {
    }

    public Emp(String e_name, String e_pass) {
        this.e_name = e_name;
        this.e_pass = e_pass;
    }

    public Date getE_date() {
        return e_date;
    }

    public void setE_date(Date e_date) {
        this.e_date = e_date;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_pass() {
        return e_pass;
    }

    public void setE_pass(String e_pass) {
        this.e_pass = e_pass;
    }

    public Integer getE_p_id() {
        return e_p_id;
    }

    public void setE_p_id(Integer e_p_id) {
        this.e_p_id = e_p_id;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public BigInteger getE_phone() {
        return e_phone;
    }

    public void setE_phone(BigInteger e_phone) {
        this.e_phone = e_phone;
    }

    public Integer getE_d_id() {
        return e_d_id;
    }

    public void setE_d_id(Integer e_d_id) {
        this.e_d_id = e_d_id;
    }

    public String getE_realName() {
        return e_realName;
    }

    public void setE_realName(String e_realName) {
        this.e_realName = e_realName;
    }

    public Double getE_salary() {
        return e_salary;
    }

    public void setE_salary(Double e_salary) {
        this.e_salary = e_salary;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public Integer getE_state() {
        return e_state;
    }

    public void setE_state(Integer e_state) {
        this.e_state = e_state;
    }

    public Integer getE_age() {
        return e_age;
    }

    public void setE_age(Integer e_age) {
        this.e_age = e_age;
    }
}
