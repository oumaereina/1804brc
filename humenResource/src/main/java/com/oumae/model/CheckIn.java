package com.oumae.model;

import java.util.Date;

/**
 * Created by oumaereina on 2018/10/30.
 */
public class CheckIn {
    private Integer c_id;
    private Integer c_eid;
    private Integer c_edid;
    private Integer c_epid;
    private Date c_time;
    private Integer c_state;
    public CheckIn() {
    }

    public CheckIn(Integer c_eid, Integer c_edid, Integer c_epid, Date c_time, Integer c_state) {
        this.c_eid = c_eid;
        this.c_edid = c_edid;
        this.c_epid = c_epid;
        this.c_time = c_time;
        this.c_state = c_state;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getC_state() {
        return c_state;
    }

    public void setC_state(Integer c_state) {
        this.c_state = c_state;
    }

    public Integer getC_eid() {
        return c_eid;
    }

    public void setC_eid(Integer c_eid) {
        this.c_eid = c_eid;
    }

    public Integer getC_edid() {
        return c_edid;
    }

    public void setC_edid(Integer c_edid) {
        this.c_edid = c_edid;
    }

    public Integer getC_epid() {
        return c_epid;
    }

    public void setC_epid(Integer c_epid) {
        this.c_epid = c_epid;
    }

    public Date getC_time() {
        return c_time;
    }

    public void setC_time(Date c_time) {
        this.c_time = c_time;
    }
}
