package com.wj.mapper;

import com.wj.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 */
@Mapper
public interface DeptMapper {

@Select("select * from dept")
    List<Dept> list();
@Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);
@Insert("insert into dept(name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
@Select("select * from dept where id = #{id}")
    Dept getByID(Integer id);
@Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
