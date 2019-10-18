package com.zl;

import com.zl.bean.Employee;
import com.zl.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: TestMp
 * @Description: TODO
 * @Author: zl
 * @Date: 2019/10/15 22:25
 * @Version: 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMp {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testCon() {
        Employee employee = new Employee();
        employee.setLastName("2019-10-15");
        employee.setAge(15);
        employee.setEmail("zhanglei@qq.com");
        employee.setGender(1);
        employeeMapper.insert(employee);
    }

    @Test
    public void testSelectCustomizer() {
        List<Employee> employees = employeeMapper.selectCustomizer();
        System.out.println(employees);
    }

}
