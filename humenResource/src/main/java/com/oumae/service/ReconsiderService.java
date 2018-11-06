package com.oumae.service;

import com.oumae.model.Reconsider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by oumaereina on 2018/11/1.
 */
public interface ReconsiderService {
    boolean insertReconsider(Reconsider reconsider);
    boolean updateReconsider(Reconsider reconsider);
    List<Reconsider> selectByMonth(Integer month,Integer rc_state);
    Reconsider selectById(Integer rc_id);
    List<Reconsider> selectByMonthEid(Integer month,Integer rc_eid);
}
