package com.oumae.utils;

/**
 * Created by oumaereina on 2018/9/7.
 */
public class DoPage {
    //设定每页显示的页面容量
    private static final int PAGESIZE = 4;
    //得到总页数
    public static int getTotalPages(int totalRows){
        return totalRows%PAGESIZE==0?totalRows/PAGESIZE:totalRows/PAGESIZE+1;
    }
}
