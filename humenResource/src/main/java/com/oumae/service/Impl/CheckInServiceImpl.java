package com.oumae.service.Impl;

import com.oumae.dao.CheckInDao;
import com.oumae.model.CheckIn;
import com.oumae.service.CheckInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/30.
 */
@Service
public class CheckInServiceImpl implements CheckInService{
    @Resource
    private CheckInDao checkInDao;
    public boolean insertCheckIn(CheckIn checkIn) {
        if(checkIn!=null){
            Integer integer = checkInDao.insertCheckIn(checkIn);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean deleteCheckIn(Integer c_id) {
        if(c_id!=null){
            Integer integer = checkInDao.deleteCheckIn(c_id);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateCheckIn(CheckIn checkIn) {
        if(checkIn!=null){
            Integer integer = checkInDao.updateCheckIn(checkIn);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public CheckIn selectById(Integer c_id) {
        if(c_id!=null){
            CheckIn checkIn = checkInDao.selectById(c_id);
            return checkIn;
        }
        return null;
    }

    public List<CheckIn> selectByEid(Integer c_eid) {
        if(c_eid!=null){
            List<CheckIn> checkIns = checkInDao.selectByEid(c_eid);
            return checkIns;
        }
        return null;
    }

    public List<CheckIn> selectToday(Date dtcol,Integer c_state,Integer c_eid) {
        List<CheckIn> checkIns = checkInDao.selectToday(dtcol,c_state,c_eid);
        return checkIns;
    }
}
