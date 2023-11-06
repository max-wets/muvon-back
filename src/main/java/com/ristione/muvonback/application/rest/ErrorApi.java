package com.ristione.muvonback.application.rest;

import com.ristione.muvonback.domain.entities.OperationResult;

public record ErrorApi(String code, String label) {

    public ErrorApi(OperationResult operationResult) {
        this(operationResult.code(), operationResult.label());
    }
}
