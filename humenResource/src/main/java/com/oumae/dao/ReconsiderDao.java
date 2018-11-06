package com.oumae.dao;

import com.oumae.model.Reconsider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by oumaereina on 2018/11/1.
 */
public interface ReconsiderDao {
    Integer insertReconsider(Reconsider reconsider);
    Integer updateReconsider(Reconsider reconsider);
    List<Reconsider> selectByMonth(@Param("month")Integer month,@Param("rc_state")Integer rc_state);
    Reconsider selectById(Integer rc_id);
    List<Reconsider> selectByMonthEid(@Param("month")Integer month,@Param("rc_eid")Integer rc_eid);
}
