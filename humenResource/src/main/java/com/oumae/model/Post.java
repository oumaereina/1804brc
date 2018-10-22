package com.oumae.model;

/**
 * Created by oumaereina on 2018/10/22.
 */
/*¸ÚÎ»*/
public class Post {
    private Integer P_ID;
    private String P_NAME;
    private Integer P_D_ID;
    private Integer P_NUM;

    public Post() {
    }

    public Integer getP_NUM() {
        return P_NUM;
    }

    public void setP_NUM(Integer p_NUM) {
        P_NUM = p_NUM;
    }

    public Integer getP_ID() {
        return P_ID;
    }

    public void setP_ID(Integer p_ID) {
        P_ID = p_ID;
    }

    public String getP_NAME() {
        return P_NAME;
    }

    public void setP_NAME(String p_NAME) {
        P_NAME = p_NAME;
    }

    public Integer getP_D_ID() {
        return P_D_ID;
    }

    public void setP_D_ID(Integer p_D_ID) {
        P_D_ID = p_D_ID;
    }
}
