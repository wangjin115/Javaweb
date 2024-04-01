package com.wj;

import com.wj.mapper.EmpMapper;
import com.wj.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
 @Autowired
    private EmpMapper empMapper;
    @Test
    public void testDelete(){
        empMapper.delete(17);

    }

//    @Test
//    public void testListEmp(){
//        List<Emp> empList=empMapper.list();
//        empList.stream().forEach(emp ->
//                System.out.println(emp));
//    }
    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(14);
        System.out.println(emp);

    }
    @Test
    public void testList(){
        List<Emp> empList =empMapper.list("张",(short) 1, LocalDate.of(2010,1,1),
                LocalDate.of(2020,1,1));
        System.out.println(empList);

    }




}
