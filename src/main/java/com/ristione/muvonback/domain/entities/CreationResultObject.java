package com.ristione.muvonback.domain.entities;

import java.util.List;

public record CreationResultObject<ObjectType>(
        String activityId,
        ObjectType object,
        List<? extends OperationResult> errors,
        List<? extends OperationResult> warnings
) {
}
