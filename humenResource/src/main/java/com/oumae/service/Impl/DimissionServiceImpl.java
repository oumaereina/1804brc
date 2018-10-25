package com.oumae.service.Impl;

import com.oumae.dao.DimissionDao;
import com.oumae.model.Dimission;
import com.oumae.service.DimissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by oumaereina on 2018/10/25.
 */
@Service
public class DimissionServiceImpl implements DimissionService{
    @Resource
    private DimissionDao dimissionDao;

    public boolean insertDimission(Dimission dimission) {
        if(dimission!=null){
            Integer integer = dimissionDao.insertDimission(dimission);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public Dimission selectDimissionByEid(Integer dm_e_id) {
        Dimission dimission = dimissionDao.selectDimissionByEid(dm_e_id);
        return dimission;
    }
}
