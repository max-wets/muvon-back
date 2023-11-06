package com.ristione.muvonback.application.rest;

import com.ristione.muvonback.domain.entities.OperationResult;

public record WarningApi(String code, String label) {

    public WarningApi(OperationResult operationResult) {
        this(operationResult.code(), operationResult.label());
    }
}
