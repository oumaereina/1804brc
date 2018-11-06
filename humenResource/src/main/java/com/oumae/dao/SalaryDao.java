package com.oumae.dao;

import com.oumae.model.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/31.
 */
public interface SalaryDao {
    Integer insertSalary(Salary salary);
    List<Salary> selectByEid(@Param("s_eid") Integer s_eid, @Param("month") Integer month);
    Salary selectById(Integer s_id);
    List<Salary> selectByMonth(Integer month);
}
