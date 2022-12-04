package com.hydraulic.applyforme.controller.exception;

import com.hydraulic.applyforme.model.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> validation(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<String, Object>();
        Map<String, Object> errMap = new HashMap<String, Object>();
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
    public Object unique(DataIntegrityViolationException ex) {
        final Map<String, Object> errors = new HashMap<>();
        errors.put("entityName", "Unknown");
        errors.put("message", "One of fields submitted matches that of an existing entity or the referenced entity id does not exist, all existent and new entities field must be unique and referenced ids must exist.");
        errors.put("code" , Integer.toString(HttpStatus.BAD_REQUEST.value()));
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CountryNotFoundException.class)
    public Object notFound(CountryNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", CountryNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CountryDuplicateEntityException.class)
    public Object duplicate(CountryDuplicateEntityException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", CountryDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.CONFLICT.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoleNotFoundException.class)
    public Object notFound(RoleNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", RoleNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RoleDuplicateEntityException.class)
    public Object duplicate(RoleDuplicateEntityException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", RoleDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.CONFLICT.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ApplyForMeNotFoundException.class)
    public Object notFound(ApplyForMeNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", ApplyForMeNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ApplyForMeDuplicateEntityException.class)
    public Object duplicate(ApplyForMeDuplicateEntityException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", ApplyForMeDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.CONFLICT.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SalaryRangeNotFoundException.class)
    public Object notFound(SalaryRangeNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", SalaryRangeNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResetPasswordInvalidTokenException.class)
    public Object invalidity(ResetPasswordInvalidTokenException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", ResetPasswordInvalidTokenException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(SalaryRangeDuplicateEntityException.class)
    public Object duplicate(SalaryRangeDuplicateEntityException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", SalaryRangeDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.CONFLICT.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MemberNotFoundException.class)
    public Object notFound(MemberNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", MemberNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailDeliveryException.class)
    public Object delivery(EmailDeliveryException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", EmailDeliveryException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidResetTokenException.class)
    public Object invalidity(InvalidResetTokenException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", InvalidResetTokenException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    public Object notFound(UsernameNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", UsernameNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = {AccessDeniedException.class})
    public Object forbidden(AccessDeniedException ex, HttpServletRequest request) {
        final Map<String, Object> body = new HashMap<>();
        body.put("error", "Forbidden");
        body.put("path", request.getServletPath());
        body.put("message", "You are not allowed to access this resource");
        body.put("code", String.valueOf(HttpStatus.FORBIDDEN.value()));
        return body;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public Object unauthorized(AuthenticationException ex, HttpServletRequest request) {
        final Map<String, Object> body = new HashMap<>();
        body.put("error", "Unauthorized");
        body.put("path", request.getServletPath());
        body.put("message", ex.getMessage());
        body.put("code", String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        return body;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProfessionalNotFoundException.class)
    public Object notFound(ProfessionalNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", ProfessionalNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PrivacyPolicyException.class)
    public Object generic(PrivacyPolicyException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", "Apply For Me");
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordMismatchException.class)
    public Object mismatch(PasswordMismatchException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", "Member");
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.BAD_REQUEST.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public Object exists(EmailAlreadyExistsException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", EmailAlreadyExistsException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.CONFLICT.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object support(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        final Map<String, Object> body = new HashMap<>();
        body.put("error", "Method Not Supported");
        body.put("path", request.getServletPath());
        body.put("message", "Request method" + request.getMethod() + " not supported");
        body.put("code", String.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()));
        return body;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(JobTitleNotFoundException.class)
    public Object notFound(JobTitleNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", JobTitleNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(JobTitleDuplicateEntityException.class)
    public Object duplicate(JobTitleDuplicateEntityException ex) {
        final Map<String, Object> errors = new HashMap<>();
        errors.put("entityName", JobTitleDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.CONFLICT.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CoverLetterTemplateNotFoundException.class)
    public Object notFound(CoverLetterTemplateNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", CoverLetterTemplateNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CoverLetterTemplateDuplicateEntityException.class)
    public Object duplicate(CoverLetterTemplateDuplicateEntityException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", CoverLetterTemplateDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.CONFLICT.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProfessionalProfileNotFoundException.class)
    public Object notFound(ProfessionalProfileNotFoundException ex) {
        final Map<String, Object> errors = new HashMap<String, Object>();
        errors.put("entityName", ProfessionalProfileNotFoundException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.NOT_FOUND.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ProfessionalProfileDuplicateEntityException.class)
    public Object duplicate(ProfessionalProfileDuplicateEntityException ex) {
        final Map<String, Object> errors = new HashMap<>();
        errors.put("entityName", ProfessionalProfileDuplicateEntityException.ENTITY_NAME);
        errors.put("message", ex.getMessage());
        ex.setCode(HttpStatus.CONFLICT.value());
        errors.put("code", ex.getCode().toString());
        return errors;
    }

}
