package com.zl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zl.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: EmployeeMapper
 * @Description: TODO
 * @Author: zl
 * @Date: 2019/10/15 22:46
 * @Version: 1.0
 **/
public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> selectCustomizer();
}
