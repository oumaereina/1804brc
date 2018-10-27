package com.oumae.dao;

import com.oumae.model.Emp;
import com.oumae.model.TraToEmp;
import com.oumae.model.Train;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/27.
 */
public interface TraToEmpDao {
    TraToEmp selectByEidTid(TraToEmp traToEmp);
    Integer insertTE(TraToEmp traToEmp);
    Integer deleteTE(Integer tm_id);
    Integer updateTE(TraToEmp traToEmp);
}
