package com.springboot.Assignments.weekOneAssignment;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "syrup.type", havingValue = "Chocolate")
public class ChocolateSyrupImpl implements Syrup{
    @Override
    public String getSyrupType() {
        return "Chocolate Syrup";
    }
}
