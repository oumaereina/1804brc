package com.oumae.dao;

import com.oumae.model.Emp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface EmpDao {
    Integer insertEmp(Emp emp);
    Integer deleteEmpById(Integer E_ID);
    Integer updateEmpById(Emp emp);
    Emp selectById(Integer E_ID);
    List<Emp> selectEmpByPid(Integer E_P_ID);
    List<Emp> selectEmpByDid(Integer E_D_ID);
    List<Emp> selectEmpByPidLimit(HashMap<String,Object> hashMap);
    List<Emp> selectEmpByDidLimit(HashMap<String,Object> hashMap);
}
