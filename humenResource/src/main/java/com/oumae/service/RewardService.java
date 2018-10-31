package com.oumae.service;

import com.oumae.model.Reward;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/30.
 */
public interface RewardService {
    boolean insertReward(Reward reward);
    boolean updateReward(Reward reward);
    List<Reward> selectByEid(Integer rm_eid);
    Reward selectById(Integer rm_id);
    List<Reward> selectToday(Integer r_state,Integer r_eid);
    List<Reward> selectByMonth(Integer month);
}
