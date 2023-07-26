package com.library.validation;


import com.library.service.category.CategoryService;
import org.hibernate.validator.internal.util.annotation.ConstraintAnnotationDescriptor;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName,Object> {

    private String idField;  //category name
    private String nameField; //category name

    @Override
    public void initialize(UniqueCategoryName constraintAnnotation) {

        this.nameField= constraintAnnotation.nameField();
    }

    @Autowired
    private CategoryService service ;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String nameValue= new BeanWrapperImpl(value).getPropertyValue(nameField).toString();
        Boolean isFoundSameName= service.checkExistingCategoryName(nameValue);
        return !isFoundSameName;
    }
}
