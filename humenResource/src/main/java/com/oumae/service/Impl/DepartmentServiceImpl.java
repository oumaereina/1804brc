package com.oumae.service.Impl;

import com.oumae.dao.DepartmentDao;
import com.oumae.model.Department;
import com.oumae.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Resource
    private DepartmentDao departmentDao;
    public boolean insertDepartment(Department department) {
        Department department1 = departmentDao.selectByName(department.getD_NAME());
        if(department1!=null){
            return false;
        }
        if(department!=null){
            Integer integer = departmentDao.insertDepartment(department);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean deleteDepartmentById(Integer D_ID) {
        if(D_ID!=null){
            Integer integer = departmentDao.deleteDepartmentById(D_ID);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean updateDepartmentById(Department department) {
        if(department!=null){
            Integer integer = departmentDao.updateDepartmentById(department);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public Department selectById(Integer D_ID) {
        Department department = departmentDao.selectById(D_ID);
        return department;
    }

    public List<Department> selectAll() {
        List<Department> departments = departmentDao.selectAll();
        return departments;
    }
}
