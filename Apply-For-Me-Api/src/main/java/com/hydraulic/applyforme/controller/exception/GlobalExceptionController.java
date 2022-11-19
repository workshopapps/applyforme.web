package com.hydraulic.applyforme.controller.exception;

import com.hydraulic.applyforme.model.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@RestControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> dtoDataValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<String, Object>();
        Map<String, String> errMap = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(new Consumer<ObjectError>() {
            @Override
            public void accept(ObjectError error) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errMap.put(fieldName, errorMessage);
            }
        });
        errors.put("message", errMap);
        errors.put("errorType", "dataValidation");
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Object uniqueValue(DataIntegrityViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("entityName", "Unknown");
        errors.put("message", "One of fields submitted matches that of an existing entity or the referenced entity id does not exist, all existent and new entities field must be unique and referenced ids must exist.");
        errors.put("code" , Integer.toString(HttpStatus.BAD_REQUEST.value()));
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CountryNotFoundException.class)
    public Object notFound(CountryNotFoundException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", CountryNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CountryDuplicateEntityException.class)
    public Object handleDuplicate(CountryDuplicateEntityException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", CountryDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoleNotFoundException.class)
    public Object notFound(RoleNotFoundException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", RoleNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RoleDuplicateEntityException.class)
    public Object handleDuplicate(RoleDuplicateEntityException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", RoleDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ApplyForMeNotFoundException.class)
    public Object notFound(ApplyForMeNotFoundException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", ApplyForMeNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplyForMeDuplicateEntityException.class)
    public Object handleDuplicate(ApplyForMeDuplicateEntityException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", ApplyForMeDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SalaryRangeNotFoundException.class)
    public Object notFound(SalaryRangeNotFoundException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", SalaryRangeNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SalaryRangeDuplicateEntityException.class)
    public Object handleDuplicate(SalaryRangeDuplicateEntityException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", SalaryRangeDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MemberNotFoundException.class)
    public Object notFound(MemberNotFoundException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("entityName", MemberNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }
}
