package com.oumae.service;

import com.oumae.dao.TraToEmpDao;
import com.oumae.model.TraToEmp;

/**
 * Created by oumaereina on 2018/10/27.
 */
public interface TraToEmpService {
    TraToEmp selectByEidTid(Integer tm_eid,Integer tm_tid);
    boolean insertTE(TraToEmp traToEmp);
    boolean deleteTE(Integer tm_id);
    boolean updateTE(TraToEmp traToEmp);
}
