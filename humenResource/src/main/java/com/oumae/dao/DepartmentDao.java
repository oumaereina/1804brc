package com.oumae.dao;

import com.oumae.model.Department;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface DepartmentDao {
    Integer insertDepartment(Department department);
    Integer deleteDepartmentById(Integer d_id);
    Integer updateDepartmentById(Department department);
    Department selectById(Integer d_id);
    Department selectByName(String d_name);
    List<Department> selectAll();
}
