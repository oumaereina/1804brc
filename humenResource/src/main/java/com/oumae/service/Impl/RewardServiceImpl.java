package com.oumae.service.Impl;

import com.oumae.dao.RewardDao;
import com.oumae.model.Reward;
import com.oumae.service.RewardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/30.
 */
@Service
public class RewardServiceImpl implements RewardService{
    @Resource
    private RewardDao rewardDao;
    public boolean insertReward(Reward reward) {
        if(reward!=null){
            Integer row = rewardDao.insertReward(reward);
            if(row==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateReward(Reward reward) {
        if(reward!=null){
            Integer row = rewardDao.updateReward(reward);
            if(row==1){
                return true;
            }
        }
        return false;
    }

    public List<Reward> selectByEid(Integer rm_eid) {
        if(rm_eid!=null){
            List<Reward> rewards = rewardDao.selectByEid(rm_eid);
            return rewards;
        }
        return null;
    }

    public Reward selectById(Integer rm_id) {
        if(rm_id!=null){
            Reward reward = rewardDao.selectById(rm_id);
            return reward;
        }
        return null;
    }

    public List<Reward> selectToday(Integer r_state,Integer r_eid) {
        List<Reward> rewards = rewardDao.selectToday(r_state,r_eid);
        return rewards;
    }

    public List<Reward> selectByMonth(Integer month) {
        List<Reward> rewards = rewardDao.selectByMonth(month);
        return rewards;
    }

    public List<Reward> selectByMonthEid(Integer r_eid, Integer month) {
        List<Reward> rewards = rewardDao.selectByMonthEid(r_eid, month);
        return rewards;
    }
}
