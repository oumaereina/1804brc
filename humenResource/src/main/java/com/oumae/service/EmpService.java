package com.oumae.service;

import com.oumae.model.Emp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface EmpService {
    boolean insertEmp(Emp emp);
    boolean deleteEmpById(Integer E_ID);
    boolean updateEmpById(Emp emp);
    Emp selectById(Integer E_ID);
    Emp selectByNamePass(Emp emp);
    List<Emp> selectEmpByPid(Integer E_P_ID);
    List<Emp> selectEmpByDid(Integer E_D_ID);
    List<Emp> selectEmpByPidLimit(int currentPage, int pageSize,Integer E_P_ID);
    List<Emp> selectEmpByDidLimit(int currentPage, int pageSize,Integer E_D_ID);
}
