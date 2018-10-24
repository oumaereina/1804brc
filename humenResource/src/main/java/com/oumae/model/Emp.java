package com.oumae.model;

import java.math.BigInteger;

/**
 * Created by oumaereina on 2018/10/22.
 */
/*员工*/
public class Emp {
    private Integer E_ID;
    private String E_NAME;
    private String E_PASS;
    private Integer E_P_ID;/*岗位*/
    private String E_MAIL;
    private BigInteger E_PHONE;
    private Integer E_D_ID;/*部门*/
    private String E_REALNAME;
    private Double E_SALARY;
    private String E_SEX;
    private Integer E_STATE;
    public Emp() {
    }

    public Emp(String e_NAME, String e_PASS) {
        E_NAME = e_NAME;
        E_PASS = e_PASS;
    }

    public String getE_SEX() {
        return E_SEX;
    }

    public void setE_SEX(String e_SEX) {
        E_SEX = e_SEX;
    }

    public Integer getE_STATE() {
        return E_STATE;
    }

    public void setE_STATE(Integer e_STATE) {
        E_STATE = e_STATE;
    }

    public Double getE_SALARY() {
        return E_SALARY;
    }

    public void setE_SALARY(Double e_SALARY) {
        E_SALARY = e_SALARY;
    }

    public String getE_REALNAME() {
        return E_REALNAME;
    }

    public void setE_REALNAME(String e_REALNAME) {
        E_REALNAME = e_REALNAME;
    }

    public Integer getE_ID() {
        return E_ID;
    }

    public void setE_ID(Integer e_ID) {
        E_ID = e_ID;
    }

    public String getE_NAME() {
        return E_NAME;
    }

    public void setE_NAME(String e_NAME) {
        E_NAME = e_NAME;
    }

    public String getE_PASS() {
        return E_PASS;
    }

    public void setE_PASS(String e_PASS) {
        E_PASS = e_PASS;
    }

    public Integer getE_P_ID() {
        return E_P_ID;
    }

    public void setE_P_ID(Integer e_P_ID) {
        E_P_ID = e_P_ID;
    }

    public String getE_MAIL() {
        return E_MAIL;
    }

    public void setE_MAIL(String e_MAIL) {
        E_MAIL = e_MAIL;
    }

    public BigInteger getE_PHONE() {
        return E_PHONE;
    }

    public void setE_PHONE(BigInteger e_PHONE) {
        E_PHONE = e_PHONE;
    }

    public Integer getE_D_ID() {
        return E_D_ID;
    }

    public void setE_D_ID(Integer e_D_ID) {
        E_D_ID = e_D_ID;
    }
}
