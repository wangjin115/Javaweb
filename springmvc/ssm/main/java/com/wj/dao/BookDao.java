package com.wj.dao;

import com.wj.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 */
public interface BookDao {
    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    //#{}这个参数名需要和 Java 对象中的属性名一致
    public int save(Book book);
    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    public int update(Book book);
    @Delete("delete from tbl_book where id = #{id}")
    public int delete(Integer id);
    @Select("select * from tbl_book where id = #{id}")
    public Book getById(Integer id);
    @Select("select * from tbl_book")
    public List<Book> getAll();
}
