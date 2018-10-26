package com.oumae.model;

import java.util.Date;

/**
 * Created by oumaereina on 2018/10/22.
 */
/*√Ê ‘—˚«Î*/
public class Invite {
    private Integer I_ID;
    private Integer I_VID;
    private Integer I_STATE;
    private String I_DATE;
    public Invite() {
    }

    public String getI_DATE() {
        return I_DATE;
    }

    public Invite(Integer i_VID, Integer i_STATE, String i_DATE) {
        I_VID = i_VID;
        I_STATE = i_STATE;
        I_DATE = i_DATE;
    }

    public void setI_DATE(String i_DATE) {
        I_DATE = i_DATE;
    }

    public Integer getI_ID() {
        return I_ID;
    }

    public void setI_ID(Integer i_ID) {
        I_ID = i_ID;
    }

    public Integer getI_VID() {
        return I_VID;
    }

    public void setI_VID(Integer i_VID) {
        I_VID = i_VID;
    }

    public Integer getI_STATE() {
        return I_STATE;
    }

    public void setI_STATE(Integer i_STATE) {
        I_STATE = i_STATE;
    }
}
