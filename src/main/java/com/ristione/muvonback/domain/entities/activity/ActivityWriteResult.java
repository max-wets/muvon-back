package com.ristione.muvonback.domain.entities.activity;

import com.ristione.muvonback.domain.entities.BusinessWarning;
import com.ristione.muvonback.domain.entities.OperationResult;

import java.util.List;

public record ActivityWriteResult(
        Long activityId,
        List<OperationResult> errors,
        List<BusinessWarning> warnings
) {
}
