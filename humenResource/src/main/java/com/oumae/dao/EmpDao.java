package com.oumae.dao;

import com.oumae.model.Emp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface EmpDao {
    Emp selectTrainByIdAll(Integer t_id);
    Integer insertEmp(Emp emp);
    Integer deleteEmpById(Integer e_id);
    Integer updateEmpById(Emp emp);
    Emp selectById(Integer e_id);
    Emp selectByNamePass(Emp emp);
    Emp selectByVid(Integer e_vid);
    List<Emp> selectEmpByPid(Integer e_p_id);
    List<Emp> selectAllEmp();
    List<Emp> selectEmpByDid(Integer e_d_id);
    List<Emp> selectEmpByPidLimit(HashMap<String,Object> hashMap);
    List<Emp> selectEmpByDidLimit(HashMap<String,Object> hashMap);
}
