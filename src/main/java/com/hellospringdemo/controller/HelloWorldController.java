package com.hellospringdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

@RequestMapping("/showForm") 
    public String showForm() {
        return "helloworld-form";
}

@RequestMapping("/processForm") 
    public String processForm() {
        return "helloworld";
}

@RequestMapping("/processFormVersionTwo")	
	public String letsShoutDude(HttpServletRequest request, Model model) {

	System.out.println("processFormVersionTwo");
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;

		System.out.println("result " + result);
		
		// add message to the model
        model.addAttribute("message", result);
        
        request.setAttribute("message", result);
				
		return "helloworld";
	}
    
}