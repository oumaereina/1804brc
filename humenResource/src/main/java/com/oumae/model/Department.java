package com.oumae.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by oumaereina on 2018/10/22.
 */
/*部门*/
public class Department implements Serializable{
    private Integer D_ID;
    private String D_NAME;
    private Integer D_NUM;
    private Date D_DATE;//创建日期
    public Department() {
    }

    public Date getD_DATE() {
        return D_DATE;
    }

    public void setD_DATE(Date d_DATE) {
        D_DATE = d_DATE;
    }

    public Integer getD_NUM() {
        return D_NUM;
    }

    public void setD_NUM(Integer d_NUM) {
        D_NUM = d_NUM;
    }

    public Integer getD_ID() {
        return D_ID;
    }

    public void setD_ID(Integer d_ID) {
        D_ID = d_ID;
    }

    public String getD_NAME() {
        return D_NAME;
    }

    public void setD_NAME(String d_NAME) {
        D_NAME = d_NAME;
    }
}
