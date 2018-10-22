package com.oumae.service;

import com.oumae.model.Department;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface DepartmentService {
    boolean insertDepartment(Department department);
    boolean deleteDepartmentById(Integer D_ID);
    boolean updateDepartmentById(Department department);
    Department selectById(Integer D_ID);
    List<Department> selectAll();
}
