package com.example.finalexercice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String ressourceName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFoundException(String ressourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s: %s", ressourceName, fieldName, fieldValue));
        this.ressourceName = ressourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getRessourceName() {
        return ressourceName;
    }

    public void setRessourceName(String ressourceName) {
        this.ressourceName = ressourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
