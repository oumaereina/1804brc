package com.oumae.service.Impl;

import com.oumae.dao.EmploymentDao;
import com.oumae.model.Employment;
import com.oumae.service.EmploymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/21.
 */
@Service
public class EmploymentServiceImpl implements EmploymentService{
    @Resource
    private EmploymentDao employmentDao;

    public Employment insertEmpById(Integer EM_ID) {
        Employment employment = employmentDao.selectEmpById(EM_ID);
        return employment;
    }

    public boolean insertEmp(Employment employment) {
        if(employment!=null){
            Integer integer = employmentDao.insertEmp(employment);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmpById(Integer id) {
        if(id!=null){
            Integer integer = employmentDao.deleteEmpById(id);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateEmpById(Employment employment) {
        if(employment!=null){
            Integer integer = employmentDao.updateEmpById(employment);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public List<Employment> selectAllEmployment() {
        List<Employment> employments = employmentDao.selectAllEmployment();
        if(employments!=null){
            return employments;
        }
        return null;
    }

    public List<Employment> getEmploymentByLimit(int currentPage, int pageSize) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("currentPage",(currentPage-1)*pageSize+1);
        map.put("pageSize",pageSize*currentPage);
        List<Employment> employments = employmentDao.getEmploymentByLimit(map);
        if(employments!=null){
            return employments;
        }
        return null;
    }
}
