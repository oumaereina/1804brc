package com.oumae.model;

import java.io.Serializable;

/**
 * Created by oumaereina on 2018/10/22.
 */
/*��λ*/
public class Post implements Serializable{
    private Integer p_id;
    private String pname;
    private Integer P_D_ID;
    private Integer P_NUM;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Post{" +
                "P_ID=" + p_id +
                ", P_NAME='" + pname + '\'' +
                ", P_D_ID=" + P_D_ID +
                ", P_NUM=" + P_NUM +
                '}';
    }

    public Post() {
    }

    public Integer getP_NUM() {
        return P_NUM;
    }

    public void setP_NUM(Integer p_NUM) {
        P_NUM = p_NUM;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getP_D_ID() {
        return P_D_ID;
    }

    public void setP_D_ID(Integer p_D_ID) {
        P_D_ID = p_D_ID;
    }
}
