package com.hellospringdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override    
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {

        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }        
        else {
            result = true;
        }

        return result;
    }    
}
