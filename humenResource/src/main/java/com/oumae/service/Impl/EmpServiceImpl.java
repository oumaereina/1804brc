package com.oumae.service.Impl;

import com.oumae.dao.EmpDao;
import com.oumae.model.Emp;
import com.oumae.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
@Service
public class EmpServiceImpl implements EmpService{
    @Resource
    private EmpDao empDao;
    public boolean insertEmp(Emp emp) {
        if(emp!=null){
            Integer integer = empDao.insertEmp(emp);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmpById(Integer E_ID) {
        if(E_ID!=null){
            Integer integer = empDao.deleteEmpById(E_ID);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateEmpById(Emp emp) {
        if(emp!=null){
            Integer integer = empDao.updateEmpById(emp);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public Emp selectById(Integer E_ID) {
        Emp emp = selectById(E_ID);
        return emp;
    }

    public List<Emp> selectEmpByPid(Integer E_P_ID) {
        List<Emp> emps = empDao.selectEmpByPid(E_P_ID);
        return emps;
    }

    public List<Emp> selectEmpByDid(Integer E_D_ID) {
        List<Emp> emps = empDao.selectEmpByPid(E_D_ID);
        return emps;
    }

    public List<Emp> selectEmpByPidLimit(int currentPage, int pageSize, Integer E_P_ID) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("currentPage",(currentPage-1)*pageSize+1);
        map.put("pageSize",pageSize*currentPage);
        map.put("E_P_ID",E_P_ID);
        List<Emp> emps = empDao.selectEmpByPidLimit(map);
        if(emps!=null){
            return emps;
        }
        return null;
    }

    public List<Emp> selectEmpByDidLimit(int currentPage, int pageSize, Integer E_D_ID) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("currentPage",(currentPage-1)*pageSize+1);
        map.put("pageSize",pageSize*currentPage);
        map.put("E_D_ID",E_D_ID);
        List<Emp> emps = empDao.selectEmpByPidLimit(map);
        if(emps!=null){
            return emps;
        }
        return null;
    }
}
