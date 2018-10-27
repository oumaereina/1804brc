package com.oumae.model;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/26.
 */
public class Train {
    private Integer t_id;
    private String t_add;
    private String t_start;
    private String t_end;
    private String t_content;
    private String t_other;/*БъЬт*/
    private Integer t_state;
    private List<Emp> emps;

    public Train() {
    }



    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_add() {
        return t_add;
    }

    public void setT_add(String t_add) {
        this.t_add = t_add;
    }

    public String getT_start() {
        return t_start;
    }

    public void setT_start(String t_start) {
        this.t_start = t_start;
    }

    public String getT_end() {
        return t_end;
    }

    public void setT_end(String t_end) {
        this.t_end = t_end;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_other() {
        return t_other;
    }

    public void setT_other(String t_other) {
        this.t_other = t_other;
    }

    public Integer getT_state() {
        return t_state;
    }

    public void setT_state(Integer t_state) {
        this.t_state = t_state;
    }
}
