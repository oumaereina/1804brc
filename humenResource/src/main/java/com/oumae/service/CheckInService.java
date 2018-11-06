package com.oumae.service;

import com.oumae.model.CheckIn;

import java.util.Date;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/30.
 */
public interface CheckInService {
    boolean insertCheckIn(CheckIn checkIn);
    boolean deleteCheckIn(Integer c_id);
    boolean updateCheckIn(CheckIn checkIn);
    CheckIn selectById(Integer c_id);
    List<CheckIn> selectByEid(Integer c_eid);
    List<CheckIn> selectToday(Date dtcol, Integer c_state,Integer c_eid);
    List<CheckIn> selectMonth(Integer month,Integer c_eid,Integer c_state);
    List<CheckIn> selectByEidLimit(int currentPage, int pageSize,Integer c_eid);
}
