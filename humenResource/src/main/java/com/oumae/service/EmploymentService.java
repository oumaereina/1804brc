package com.oumae.service;

import com.oumae.model.Employment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/21.
 */
public interface EmploymentService {
    Employment insertEmpById(Integer EM_ID);
    boolean insertEmp(Employment employment);
    boolean deleteEmpById(Integer id);
    boolean updateEmpById(Employment employment);
    List<Employment> selectAllEmployment();
    List<Employment> getEmploymentByLimit(int currentPage, int pageSize);
}
