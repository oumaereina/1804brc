package com.oumae.dao;

import com.oumae.model.Department;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface DepartmentDao {
    Integer insertDepartment(Department department);
    Integer deleteDepartmentById(Integer D_ID);
    Integer updateDepartmentById(Department department);
    Department selectById(Integer D_ID);
    List<Department> selectAll();
}
