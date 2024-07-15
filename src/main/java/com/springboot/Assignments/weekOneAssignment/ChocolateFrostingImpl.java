package com.springboot.Assignments.weekOneAssignment;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "frosting.type", havingValue = "Chocolate")
public class ChocolateFrostingImpl implements Frosting{
    @Override
    public String getFrostingType() {
        return "Chocolate Frosting";
    }
}
