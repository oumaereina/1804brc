package com.oumae.service;

import com.oumae.model.Visitor;

/**
 * Created by oumaereina on 2018/10/19.
 */
public interface VisitorService {
    boolean insertVisitor(Visitor visitor);
    Visitor getVisitorByVid(Integer V_ID);
    Visitor getVisitor(Visitor visitor);
    Visitor getVisitorByName(String v_name);
}
