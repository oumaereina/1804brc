package com.oumae.dao;

import com.oumae.model.CheckIn;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/30.
 */
public interface CheckInDao {
    Integer insertCheckIn(CheckIn checkIn);
    Integer deleteCheckIn(Integer c_id);
    Integer updateCheckIn(CheckIn checkIn);
    CheckIn selectById(Integer c_id);
    List<CheckIn> selectByEid(Integer c_eid);
    List<CheckIn> selectToday(@Param("c_time")Date c_time,@Param("c_state") Integer c_state,@Param("c_eid")Integer c_eid);
}
