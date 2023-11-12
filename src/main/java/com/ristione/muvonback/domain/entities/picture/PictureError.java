package com.ristione.muvonback.domain.entities.picture;

import com.ristione.muvonback.domain.entities.OperationResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public enum PictureError implements OperationResult {
    FAILED_UPLOAD(null, "Picture upload to storage device failed");

    private final String code;
    private final String label;
}
