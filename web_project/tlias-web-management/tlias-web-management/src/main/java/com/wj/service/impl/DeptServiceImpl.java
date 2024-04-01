package com.wj.service.impl;

import com.wj.anno.Log;
import com.wj.mapper.DeptMapper;
import com.wj.mapper.EmpMapper;
import com.wj.pojo.Dept;
import com.wj.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wj
 * @version 1.0
 */

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override

    public List<Dept> list(){
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
   // @Log
    public void delete(Integer id) throws Exception {

            deptMapper.deleteById(id); //根据id删除部门数据

//            if (true) {
//                throw new Exception("出错了");
//            }
            //根据部门id删除该部门下的员工
            empMapper.deleteByDeptId(id);


    }



//    @Transactional(rollbackFor = Exception.class)
  //  @Override
//    public void delete(Integer id) throws Exception {
//         deptMapper.deleteById(id); //根据id删除部门数据
//
//        //
//        if(true) {
//            throw new Exception("出错了");
//        }
//        //根据部门id删除该部门下的员工
//        empMapper.deleteByDeptId(id);
//
//        System.out.println("没回滚");
//    }

    @Override
  //  @Log
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getByID(Integer id) {
        Dept dept = deptMapper.getByID(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
