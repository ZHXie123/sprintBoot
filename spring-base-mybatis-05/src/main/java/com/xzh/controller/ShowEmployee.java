package com.xzh.controller;

import com.xzh.mappers.EmployeeMapper;
import com.xzh.pojo.Employee;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ShowEmployee {

    @Autowired
    private EmployeeMapper employeeMapper;


    @GetMapping("/showData")
    public String showData(Model model) {
        // 假设这是从Service获取的数据
        String data = "Hello, Spring Boot!";
        model.addAttribute("data", data);
        return "dataPage"; // 返回Thymeleaf模板文件名，不包含后缀
    }

    @GetMapping("/anotherPage")
    public String showAnotherPage(Model model) {
        // 如果需要，可以添加属性到模型中
        model.addAttribute("someAttribute", "someValue");
        return "anotherPage"; // 返回页面名称，不包括扩展名
    }

//    添加新员工
    @PostMapping("/submitRegistration")
    public String registerEmployee(@ModelAttribute Employee newEmployee) {
        // 这里可以添加验证逻辑
        System.out.println("newEmployee = " + newEmployee);
        employeeMapper.save(newEmployee);
        return "redirect:/Reg"; // 重定向回注册页面或其他页面
    }

//首页
    @GetMapping("/Reg")
    public String ToReg(Model model){
        List<Employee> employeeList = employeeMapper.getAllEmp();
        System.out.println("employeeList = " + employeeList);
        model.addAttribute("employees", employeeList);
        return "register";
    }
//    删除员工
    @PostMapping("/deleteEmployee/{empId}")
    public String ToDelete(@PathVariable Integer empId){
        int rows = employeeMapper.deleteEmp(empId);
        System.out.println("rows = " + rows);
        return "redirect:/Reg";
    }


    @PostMapping("/update")
    public String ToUpdate() {
        return null;
    }
//    修改员工
    @PostMapping("/updateEmployee/{empId}")
    public String ToUpdateEmployee(@PathVariable Integer empId,
                                   @RequestParam("empName") String empName,
                                   @RequestParam("empSalary") Double empSalary){
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setEmpSalary(empSalary);
        int rows = employeeMapper.updateEmployee(employee);
//        System.out.println("empSalary = " + empSalary);
//        System.out.println("empName = " + empName);
//        System.out.println("empId = " + empId);
        return "redirect:/Reg";

    }

    @ResponseBody
    @RequestMapping
    public List<Employee> showEmployee(){

        List<Employee> employeeList = employeeMapper.getAllEmp();

        return employeeList;
    }

    @Transactional
    @RequestMapping("delete")
    @ResponseBody
    public int deleteOne(){

        int rows = employeeMapper.deleteEmp(11);
        System.out.println("rows = " + rows);
        return rows;
    }
}
