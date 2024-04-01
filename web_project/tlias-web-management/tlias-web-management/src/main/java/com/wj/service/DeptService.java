package com.wj.service;

import com.wj.pojo.Dept;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 */
public interface DeptService {

    List<Dept> list();

    void delete(Integer id) throws Exception;

    void add(Dept dept);

    Dept getByID(Integer id);

    void update(Dept dept);
}
