package com.oumae.model;

import java.math.BigInteger;

/**
 * Created by oumaereina on 2018/10/19.
 */
/*简历*/
public class Resume {
    private Integer r_id;
    private Integer r_vid;
    private String r_name;
    private String r_sex;
    private String r_nation;/*民族*/
    private String r_bir;
    private String r_native_place;/*籍贯*/
    private String r_pol_sta;/*政治面貌*/
    private Integer r_height;
    private Integer r_weight;
    private String r_health;/*电子信箱*/
    private String r_english;
    private String r_edu;
    private String r_major;
    private BigInteger r_idc;/*身份证*/
    private BigInteger r_phone;
    private String r_add;/*地址*/
    private String r_school;
    private String r_hobby;/*工作地点/意向行业/意向岗位/工作要求*/
    private String r_self;/*自我评价*/
    private Integer R_STATE;/*简历状态*/

    public Integer getR_state() {
        return R_STATE;
    }

    public void setR_state(Integer r_state) {
        this.R_STATE = r_state;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "r_id=" + r_id +
                ", r_vid=" + r_vid +
                ", r_name='" + r_name + '\'' +
                ", r_sex='" + r_sex + '\'' +
                ", r_nation='" + r_nation + '\'' +
                ", r_bir='" + r_bir + '\'' +
                ", r_native_place='" + r_native_place + '\'' +
                ", r_pol_sta='" + r_pol_sta + '\'' +
                ", r_height=" + r_height +
                ", r_weight=" + r_weight +
                ", r_health='" + r_health + '\'' +
                ", r_english='" + r_english + '\'' +
                ", r_edu='" + r_edu + '\'' +
                ", r_major='" + r_major + '\'' +
                ", r_idc=" + r_idc +
                ", r_phone=" + r_phone +
                ", r_add='" + r_add + '\'' +
                ", r_school='" + r_school + '\'' +
                ", r_hobby='" + r_hobby + '\'' +
                ", r_self='" + r_self + '\'' +
                '}';
    }

    public Resume(Integer r_id, Integer r_vid, String r_name, String r_sex, String r_nation, String r_bir, String r_native_place, String r_pol_sta, String r_health, String r_english, String r_edu, String r_major, BigInteger r_idc, BigInteger r_phone, String r_add, String r_school, String r_hobby, String r_self) {
        this.r_id = r_id;
        this.r_vid = r_vid;
        this.r_name = r_name;
        this.r_sex = r_sex;
        this.r_nation = r_nation;
        this.r_bir = r_bir;
        this.r_native_place = r_native_place;
        this.r_pol_sta = r_pol_sta;
        this.r_health = r_health;
        this.r_english = r_english;
        this.r_edu = r_edu;
        this.r_major = r_major;
        this.r_idc = r_idc;
        this.r_phone = r_phone;
        this.r_add = r_add;
        this.r_school = r_school;
        this.r_hobby = r_hobby;
        this.r_self = r_self;
    }

    public Resume() {
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public Integer getR_vid() {
        return r_vid;
    }

    public void setR_vid(Integer r_vid) {
        this.r_vid = r_vid;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public String getR_nation() {
        return r_nation;
    }

    public void setR_nation(String r_nation) {
        this.r_nation = r_nation;
    }

    public String getR_bir() {
        return r_bir;
    }

    public void setR_bir(String r_bir) {
        this.r_bir = r_bir;
    }

    public String getR_native_place() {
        return r_native_place;
    }

    public void setR_native_place(String r_native_place) {
        this.r_native_place = r_native_place;
    }

    public String getR_pol_sta() {
        return r_pol_sta;
    }

    public void setR_pol_sta(String r_pol_sta) {
        this.r_pol_sta = r_pol_sta;
    }

    public Integer getR_height() {
        return r_height;
    }

    public void setR_height(Integer r_height) {
        this.r_height = r_height;
    }

    public Integer getR_weight() {
        return r_weight;
    }

    public void setR_weight(Integer r_weight) {
        this.r_weight = r_weight;
    }

    public String getR_health() {
        return r_health;
    }

    public void setR_health(String r_health) {
        this.r_health = r_health;
    }

    public String getR_english() {
        return r_english;
    }

    public void setR_english(String r_english) {
        this.r_english = r_english;
    }

    public String getR_edu() {
        return r_edu;
    }

    public void setR_edu(String r_edu) {
        this.r_edu = r_edu;
    }

    public String getR_major() {
        return r_major;
    }

    public void setR_major(String r_major) {
        this.r_major = r_major;
    }

    public BigInteger getR_idc() {
        return r_idc;
    }

    public void setR_idc(BigInteger r_idc) {
        this.r_idc = r_idc;
    }

    public BigInteger getR_phone() {
        return r_phone;
    }

    public void setR_phone(BigInteger r_phone) {
        this.r_phone = r_phone;
    }

    public String getR_add() {
        return r_add;
    }

    public void setR_add(String r_add) {
        this.r_add = r_add;
    }

    public String getR_school() {
        return r_school;
    }

    public void setR_school(String r_school) {
        this.r_school = r_school;
    }

    public String getR_hobby() {
        return r_hobby;
    }

    public void setR_hobby(String r_hobby) {
        this.r_hobby = r_hobby;
    }

    public String getR_self() {
        return r_self;
    }

    public void setR_self(String r_self) {
        this.r_self = r_self;
    }
}
