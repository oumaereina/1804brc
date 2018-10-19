package com.oumae.dao;

import com.oumae.model.Visitor;

/**
 * Created by oumaereina on 2018/10/19.
 */
public interface VisitorDao {
    Integer insertVisitor(Visitor visitor);
    Visitor getVisitor(Visitor visitor);
    Visitor getVisitorByName(String v_name);
}
