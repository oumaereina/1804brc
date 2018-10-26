package com.oumae.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by oumaereina on 2018/10/22.
 */
/*部门*/
public class Department implements Serializable{
    private Integer d_id;
    private String d_name;
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

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }
}
