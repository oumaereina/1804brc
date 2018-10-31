package com.oumae.model;

import java.util.Date;

/**
 * Created by oumaereina on 2018/10/31.
 */
public class Salary {
    private Integer s_id;
    private Integer s_eid;
    private Double s_salary;
    private Date s_time;

    public Salary(Integer s_eid, Double s_salary, Date s_time) {
        this.s_eid = s_eid;
        this.s_salary = s_salary;
        this.s_time = s_time;
    }

    public Salary() {
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getS_eid() {
        return s_eid;
    }

    public void setS_eid(Integer s_eid) {
        this.s_eid = s_eid;
    }

    public Double getS_salary() {
        return s_salary;
    }

    public void setS_salary(Double s_salary) {
        this.s_salary = s_salary;
    }

    public Date getS_time() {
        return s_time;
    }

    public void setS_time(Date s_time) {
        this.s_time = s_time;
    }
}
