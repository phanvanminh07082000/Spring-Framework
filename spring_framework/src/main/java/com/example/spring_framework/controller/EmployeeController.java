package com.example.spring_framework.controller;

import com.example.spring_framework.entity.Employee;
import com.example.spring_framework.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String findAllEmployees(Model model){
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "index";
    }

    @RequestMapping(value = "create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-user";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }

}