package com.wj.controller;

import com.wj.anno.Log;
import com.wj.pojo.Emp;
import com.wj.pojo.PageBean;
import com.wj.pojo.Result;
import com.wj.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author wj
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
@Autowired
    private EmpService empService;
@GetMapping   //这是查询第几页，显示几条信息
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
    log.info("分页查询，参数：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
   PageBean pageBean= empService.page(page,pageSize,name,gender,begin,end);
   return Result.success(pageBean);

    }
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
    log.info("批量删除操作，ids:{}",ids);
    empService.delete(ids);
    return Result.success();

    }
    @Log
@PostMapping
    public Result save(@RequestBody Emp emp){
    log.info("新增员工，emp：{}",emp);
    empService.save(emp);
    return Result.success();

    }

@GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
    log.info("根据ID查询员工信息，id：{}",id);
    Emp emp = empService.getById(id);
    return Result.success(emp);

    }
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
    log.info("更新员工信息：{}",emp);
    empService.update(emp);
    return Result.success();

    }
}
