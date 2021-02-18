package com.service.demo.SpringServiceDemo.utilities;

import javax.validation.ConstraintViolation;
import javax.validation.metadata.BeanDescriptor;

import com.service.demo.SpringServiceDemo.entities.ToDo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;
//spring validator
public class ToDoValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ToDo.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        ToDo toDo = (ToDo) obj;
        String description = toDo.getDescription();
        String priority = toDo.getPriority();

        if (description == null && description.equals("")){
            errors.rejectValue("description", "The filed 'description' cannot be null or empty");
        }

        if (!"high".equalsIgnoreCase(priority) && !"low".equalsIgnoreCase(priority)){
            errors.rejectValue("priority", "priority must be 'high' or 'low'");
        }



    }
}
