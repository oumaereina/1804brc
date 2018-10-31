package com.oumae.model;

import java.util.Date;

/**
 * Created by oumaereina on 2018/10/30.
 */
/*½±³Í*/
public class Reward {
    private Integer rm_id;
    private Integer rm_money;
    private Date rm_time;
    private String rm_reason;
    private Integer rm_eid;
    private Integer rm_state;
    public Reward() {
    }

    public Reward(Integer rm_money, Date rm_time, String rm_reason, Integer rm_eid, Integer rm_state) {
        this.rm_money = rm_money;
        this.rm_time = rm_time;
        this.rm_reason = rm_reason;
        this.rm_eid = rm_eid;
        this.rm_state = rm_state;
    }

    public Integer getRm_id() {
        return rm_id;
    }

    public void setRm_id(Integer rm_id) {
        this.rm_id = rm_id;
    }

    public Integer getRm_state() {
        return rm_state;
    }

    public void setRm_state(Integer rm_state) {
        this.rm_state = rm_state;
    }

    public Integer getRm_money() {
        return rm_money;
    }

    public void setRm_money(Integer rm_money) {
        this.rm_money = rm_money;
    }

    public Date getRm_time() {
        return rm_time;
    }

    public void setRm_time(Date rm_time) {
        this.rm_time = rm_time;
    }

    public String getRm_reason() {
        return rm_reason;
    }

    public void setRm_reason(String rm_reason) {
        this.rm_reason = rm_reason;
    }

    public Integer getRm_eid() {
        return rm_eid;
    }

    public void setRm_eid(Integer rm_eid) {
        this.rm_eid = rm_eid;
    }
}
