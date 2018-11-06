package com.oumae.service;

import com.oumae.model.Salary;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/31.
 */
public interface SalaryService {
    boolean insertSalary(Salary salary);
    List<Salary> selectByEid(Integer s_eid,Integer month);
    Salary selectById(Integer s_id);
    List<Salary> selectByMonth(Integer month);
}
