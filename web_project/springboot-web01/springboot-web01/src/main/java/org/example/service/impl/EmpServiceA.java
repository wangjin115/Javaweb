package org.example.service.impl;

import org.example.dao.EmpDao;
import org.example.dao.impl.EmpDaoA;
import org.example.pojo.Emp;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 */
//@Component
@Service
public class EmpServiceA implements EmpService {
    @Autowired
   // private EmpDao empDao =new EmpDaoA();
    private EmpDao empDao;


    @Override
    public List<Emp> listEmp() {
        List<Emp> empList=empDao.listEmp();

        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }

        });

            return empList;

    }
    }
