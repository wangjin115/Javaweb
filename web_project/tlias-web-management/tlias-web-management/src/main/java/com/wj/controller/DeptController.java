package com.wj.controller;

import com.wj.anno.Log;
import com.wj.pojo.Dept;
import com.wj.pojo.Result;
import com.wj.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wj
 * @version 1.0
 */
@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list(){
        log.info("查询全部部门数据");

       List<Dept> deptList= deptService.list();
        return Result.success(deptList);

    }
    @Log
@DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门：{}",id);
        deptService.delete(id);
        return Result.success();


    }
    @Log
@PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();

    }
    @GetMapping("/depts/{id}")
    public Result getByID(@PathVariable Integer id) {
        log.info("获取部门ID:{}",id);
        Dept dept = deptService.getByID(id);
        return Result.success(dept);
    }
    @Log
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门:{}",dept);
        deptService.update(dept);
        return Result.success();
    }


}
