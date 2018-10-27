package com.oumae.service.Impl;

import com.oumae.dao.TraToEmpDao;
import com.oumae.model.TraToEmp;
import com.oumae.service.TraToEmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by oumaereina on 2018/10/27.
 */
@Service
public class TraToEmpServiceImpl implements TraToEmpService{
    @Resource
    private TraToEmpDao traToEmpDao ;

    public TraToEmp selectByEidTid(Integer tm_eid, Integer tm_tid) {

        return null;
    }

    public boolean insertTE(TraToEmp traToEmp) {
        TraToEmp traToEmp1 = traToEmpDao.selectByEidTid(traToEmp);
        if(traToEmp1!=null){
            return false;
        }
        if (traToEmp!=null){
            Integer integer= traToEmpDao.insertTE(traToEmp);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean deleteTE(Integer tm_id) {
        if (tm_id!=null){
            Integer integer= traToEmpDao.deleteTE(tm_id);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateTE(TraToEmp traToEmp) {
        if (traToEmp!=null){
            Integer integer= traToEmpDao.updateTE(traToEmp);
            if(integer==1){
                return true;
            }
        }
        return false;
    }
}
