package com.oumae.dao;

import com.oumae.model.Employment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/21.
 */
public interface EmploymentDao {
    Integer insertEmp(Employment employment);
    Integer deleteEmpById(Integer id);
    Integer updateEmpById(Employment employment);
    List<Employment> selectAllEmployment();
    List<Employment> getEmploymentByLimit(HashMap<String,Object> hashMap);
}
