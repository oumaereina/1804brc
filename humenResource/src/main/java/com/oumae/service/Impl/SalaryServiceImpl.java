package com.oumae.service.Impl;

import com.oumae.dao.SalaryDao;
import com.oumae.model.Salary;
import com.oumae.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/31.
 */
@Service
public class SalaryServiceImpl implements SalaryService{
    @Resource
    private SalaryDao salaryDao;

    public boolean insertSalary(Salary salary) {
        if(salary!=null){
            Integer row = salaryDao.insertSalary(salary);
            if(row==1){
                return true;
            }
        }
        return false;
    }

    public List<Salary> selectByEid(Integer s_eid) {
        List<Salary> salaries = salaryDao.selectByEid(s_eid);
        return salaries;
    }

    public Salary selectById(Integer s_id) {
        Salary salary = salaryDao.selectById(s_id);
        return salary;
    }

    public List<Salary> selectByMonth(Integer month) {
        List<Salary> salaries = salaryDao.selectByMonth(month);
        return salaries;
    }
}
