package com.wj.service;

import com.wj.pojo.Emp;
import com.wj.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * @author wj
 * @version 1.0
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize,String name, Short gender,
                  LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
