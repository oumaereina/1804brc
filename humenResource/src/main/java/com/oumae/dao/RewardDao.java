package com.oumae.dao;

import com.oumae.model.Reward;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/30.
 */
public interface RewardDao {
    Integer insertReward(Reward reward);
    Integer updateReward(Reward reward);
    List<Reward> selectByEid(Integer rm_eid);
    Reward selectById(Integer rm_id);
    List<Reward> selectToday( @Param("r_state") Integer r_state,@Param("r_eid") Integer r_eid);
    List<Reward> selectByMonth(Integer month);
    List<Reward> selectByMonthEid(@Param("r_eid") Integer r_eid,@Param("month")Integer month);
}
