package com.oumae.utils;

/**
 * Created by oumaereina on 2018/9/7.
 */
public class DoPage {
    //�趨ÿҳ��ʾ��ҳ������
    private static final int PAGESIZE = 4;
    //�õ���ҳ��
    public static int getTotalPages(int totalRows){
        return totalRows%PAGESIZE==0?totalRows/PAGESIZE:totalRows/PAGESIZE+1;
    }
}
