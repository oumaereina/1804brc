package com.oumae.service;

import com.oumae.model.Dimission;

/**
 * Created by oumaereina on 2018/10/25.
 */
public interface DimissionService {
    boolean insertDimission(Dimission dimission);
    Dimission selectDimissionByEid(Integer dm_e_id);
}
