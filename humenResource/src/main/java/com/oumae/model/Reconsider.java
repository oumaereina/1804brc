package com.oumae.model;

import java.util.Date;

/**
 * Created by oumaereina on 2018/11/1.
 */
public class Reconsider {
    private Integer rc_id;
    private Integer rc_eid;
    private Integer rc_salaryId;
    private Integer rc_state;
    private Date rc_time;

    public Reconsider() {
    }

    public Reconsider(Integer rc_eid, Integer rc_salaryId, Integer rc_state, Date rc_time) {
        this.rc_eid = rc_eid;
        this.rc_salaryId = rc_salaryId;
        this.rc_state = rc_state;
        this.rc_time = rc_time;
    }

    public Integer getRc_id() {
        return rc_id;
    }

    public void setRc_id(Integer rc_id) {
        this.rc_id = rc_id;
    }

    public Integer getRc_eid() {
        return rc_eid;
    }

    public void setRc_eid(Integer rc_eid) {
        this.rc_eid = rc_eid;
    }

    public Integer getRc_salaryId() {
        return rc_salaryId;
    }

    public void setRc_salaryId(Integer rc_salaryId) {
        this.rc_salaryId = rc_salaryId;
    }

    public Integer getRc_state() {
        return rc_state;
    }

    public void setRc_state(Integer rc_state) {
        this.rc_state = rc_state;
    }

    public Date getRc_time() {
        return rc_time;
    }

    public void setRc_time(Date rc_time) {
        this.rc_time = rc_time;
    }
}
