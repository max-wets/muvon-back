package com.ristione.muvonback.domain.entities;

public record BusinessWarning(String code, String label) implements OperationResult {

    public BusinessWarning(OperationResult operationResult) {
        this(operationResult.code(), operationResult.label());
    }
}
