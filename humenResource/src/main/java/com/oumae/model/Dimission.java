package com.oumae.model;

/**
 * Created by oumaereina on 2018/10/25.
 */
public class Dimission {
    private Integer dm_id;
    private Integer dm_e_id;//员工id
    private String dm_result;//离职原因

    public Dimission() {
    }

    public Integer getDm_id() {
        return dm_id;
    }

    public void setDm_id(Integer dm_id) {
        this.dm_id = dm_id;
    }

    public Integer getDm_e_id() {
        return dm_e_id;
    }

    public void setDm_e_id(Integer dm_e_id) {
        this.dm_e_id = dm_e_id;
    }

    public String getDm_result() {
        return dm_result;
    }

    public void setDm_result(String dm_result) {
        this.dm_result = dm_result;
    }
}
