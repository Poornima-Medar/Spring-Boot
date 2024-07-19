package com.springboot.Assignments.weekTwoAssignment.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation,Long> {
    @Override
    public boolean isValid(Long inputValue, ConstraintValidatorContext constraintValidatorContext) {
        if(inputValue<=1) return false;
        boolean flag = true;
        int div = 2;
        while(div<inputValue){
            if(inputValue % div == 0){
                flag = false;
                break;
            }else {
                div++;
            }
        }
        return flag;
    }
}
