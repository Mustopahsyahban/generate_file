package com.library.validation;


import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompareValidator implements ConstraintValidator<Compare, Object> {

    private String fistField;  //category name
    private String secondField; //category name

    @Override
    public void initialize(Compare constraintAnnotation) {
        this.fistField= constraintAnnotation.firstField();
        this.secondField= constraintAnnotation.secoundField();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String fistValue = new BeanWrapperImpl(value).getPropertyValue(fistField).toString();
        String secondValue= new BeanWrapperImpl(value).getPropertyValue(secondField).toString();
        return fistValue.equals(secondValue);
    }
}
