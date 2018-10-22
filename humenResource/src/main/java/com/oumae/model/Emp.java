package com.oumae.model;

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
    private Integer E_PHONE;
    private Integer E_D_ID;/*部门*/

    public Emp() {
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

    public Integer getE_PHONE() {
        return E_PHONE;
    }

    public void setE_PHONE(Integer e_PHONE) {
        E_PHONE = e_PHONE;
    }

    public Integer getE_D_ID() {
        return E_D_ID;
    }

    public void setE_D_ID(Integer e_D_ID) {
        E_D_ID = e_D_ID;
    }
}
