package com.springboot.Assignments.weekTwoAssignment.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PasswordValidation,String> {

    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%_\\*\\-]).{10,20})");
        Matcher password = pattern.matcher(inputValue);
        return password.matches();
    }
}
