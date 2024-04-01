package org.example.dao.impl;

import org.example.dao.EmpDao;
import org.example.pojo.Emp;
import org.example.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 */
//@Component
    @Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList= XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
