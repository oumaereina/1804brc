package com.oumae.dao;

import com.oumae.model.Dimission;

/**
 * Created by oumaereina on 2018/10/25.
 */
public interface DimissionDao {
    Integer insertDimission(Dimission dimission);
    Dimission selectDimissionByEid(Integer dm_e_id);
}
