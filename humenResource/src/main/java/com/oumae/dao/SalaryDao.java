package com.oumae.dao;

import com.oumae.model.Salary;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/31.
 */
public interface SalaryDao {
    Integer insertSalary(Salary salary);
    List<Salary> selectByEid(Integer s_eid);
    Salary selectById(Integer s_id);
    List<Salary> selectByMonth(Integer month);
}
