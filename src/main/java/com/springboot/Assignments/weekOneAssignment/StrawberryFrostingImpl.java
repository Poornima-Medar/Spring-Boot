package com.springboot.Assignments.weekOneAssignment;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "frosting.type", havingValue = "Strawberry")
public class StrawberryFrostingImpl implements Frosting{
    @Override
    public String getFrostingType() {
        return "Strawberry Frosting";
    }
}
