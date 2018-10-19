package com.oumae.service.Impl;

import com.oumae.dao.VisitorDao;
import com.oumae.model.Visitor;
import com.oumae.service.VisitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by oumaereina on 2018/10/19.
 */
@Service
public class VisitorServiceImpl implements VisitorService{
    @Resource
    private VisitorDao visitorDao;
    /*游客注册*/
    public boolean insertVisitor(Visitor visitor) {
        if (visitor.getV_name()!=null&&visitor.getV_pass()!=null){
            Integer integer= visitorDao.insertVisitor(visitor);
            if(integer==1){
                return true;
            }
        }
        return false;
    }
    /*游客登录*/
    public Visitor getVisitor(Visitor visitor) {
        if (visitor.getV_name()!=null&&visitor.getV_pass()!=null){
            Visitor visitor1= visitorDao.getVisitor(visitor);
            if(visitor1!=null){
                return visitor1;
            }
        }
        return null;
    }

    public Visitor getVisitorByName(String v_name) {
        if(v_name!=null){
            Visitor visitor1= visitorDao.getVisitorByName(v_name);
            return visitor1;
        }
        return null;
    }
}
