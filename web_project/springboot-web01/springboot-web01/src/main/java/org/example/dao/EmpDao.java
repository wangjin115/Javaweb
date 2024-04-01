package org.example.dao;

import org.example.pojo.Emp;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 */

public interface EmpDao {
    public List<Emp> listEmp();
}
