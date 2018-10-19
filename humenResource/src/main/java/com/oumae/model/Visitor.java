package com.oumae.model;

/**
 * Created by oumaereina on 2018/10/19.
 */
/*сн©м*/
public class Visitor {
    private Integer v_id;
    private String v_name;
    private String v_pass;

    @Override
    public String toString() {
        return "Visitor{" +
                "v_id=" + v_id +
                ", v_name='" + v_name + '\'' +
                ", v_pass='" + v_pass + '\'' +
                '}';
    }

    public Visitor(String v_name, String v_pass) {
        this.v_name = v_name;
        this.v_pass = v_pass;
    }

    public Visitor() {
    }

    public Integer getV_id() {
        return v_id;
    }

    public void setV_id(Integer v_id) {
        this.v_id = v_id;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_pass() {
        return v_pass;
    }

    public void setV_pass(String v_pass) {
        this.v_pass = v_pass;
    }
}
