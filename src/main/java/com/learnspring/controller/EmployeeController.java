package com.learnspring.controller;

import com.learnspring.boostrap.DataGenerator;
import com.learnspring.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String createEmployee (Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());
        return "employee/employee-create";
    }

    @PostMapping("/list")
    public String employeeList(@Valid @ModelAttribute("employee") Employee employee,
                               BindingResult bindingResult, Model model){
                                //binding result only after the object you want to validate

        if (bindingResult.hasErrors()){ //without this validation statement, the app will crash
             model.addAttribute("states", DataGenerator.getAllStates());
            return "employee/employee-create"; //stay in the same page
        }

        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees", DataGenerator.readAllEmployees());

        return "/employee/employee-list";
    }


}
