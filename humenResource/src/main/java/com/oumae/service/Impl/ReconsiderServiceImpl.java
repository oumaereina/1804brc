package com.oumae.service.Impl;

import com.oumae.dao.ReconsiderDao;
import com.oumae.model.Reconsider;
import com.oumae.service.ReconsiderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oumaereina on 2018/11/1.
 */
@Service
public class ReconsiderServiceImpl implements ReconsiderService{
    @Resource
    private ReconsiderDao reconsiderDao;
    public boolean insertReconsider(Reconsider reconsider) {
        if(reconsider!=null){
            Integer row = reconsiderDao.insertReconsider(reconsider);
            if(row==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateReconsider(Reconsider reconsider) {
        if(reconsider!=null){
            Integer row = reconsiderDao.updateReconsider(reconsider);
            if(row==1){
                return true;
            }
        }
        return false;
    }

    public List<Reconsider> selectByMonth(Integer month,Integer rc_state) {
        List<Reconsider> reconsiders = reconsiderDao.selectByMonth(month,rc_state);
        return reconsiders;
    }

    public Reconsider selectById(Integer rc_id) {
        Reconsider reconsider = reconsiderDao.selectById(rc_id);
        return reconsider;
    }

    public List<Reconsider> selectByMonthEid(Integer month, Integer rc_eid) {
        List<Reconsider> reconsiders = reconsiderDao.selectByMonthEid(month,rc_eid);
        return reconsiders;
    }
}
