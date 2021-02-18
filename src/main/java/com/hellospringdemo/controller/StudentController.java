package com.hellospringdemo.controller;

import com.hellospringdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();

        model.addAttribute("student", student);

        // add the country options to the model 
        model.addAttribute("theCountryOptions", countryOptions); 

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("student: " + student.getFirstName());

        return "student-confirmation";
    }
    
}