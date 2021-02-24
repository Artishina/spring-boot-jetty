package com.hellospringdemo.controller;

import com.hellospringdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();

        model.addAttribute("student", student);

        // add the country options to the model 
        model.addAttribute("theCountryOptions", countryOptions); 

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request,
                                @Valid @ModelAttribute("student") Student student,
                                BindingResult bindintResult) {
        System.out.println("student: " + student.getFirstName());    
        
        System.out.println("BindingResult: " + bindintResult + "\n\n\n\n");                            

        if (bindintResult.hasErrors()) {
            request.setAttribute("theCountryOptions", countryOptions);
            return "student-form";
        }

        return "student-confirmation";
    }
    
}