package com.ristione.muvonback.domain.entities.activity;

import com.ristione.muvonback.domain.entities.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public enum ActivityError implements OperationResult {

    NO_ACTIVITY_TYPE(null, "No activity type is linked to this activity");

    private final String code;
    private final String label;
}
