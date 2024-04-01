package com.wj.mapper;

import com.wj.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

@Delete("delete from emp where id= #{id}")
  void delete(Integer id);
//@Select("select * from emp")
//List<Emp> list();

@Select("select * from emp where id= #{id}")
 Emp getById(Integer id);

    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);
}


