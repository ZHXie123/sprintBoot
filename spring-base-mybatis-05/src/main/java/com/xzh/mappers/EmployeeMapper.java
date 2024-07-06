package com.xzh.mappers;

import com.xzh.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
public interface EmployeeMapper {

    List<Employee> getAllEmp();

    int deleteEmp(@Param("id") Integer id);

    int save(@Param("employee") Employee newEmployee);
}
