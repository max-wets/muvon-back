package com.ristione.muvonback.domain.entities.activity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ActivitySourceType {
    SUPPLIER_ACTIVITY("supplier_activity");

    final String source;

    public String getSource() {
        return source;
    }

    public static ActivitySourceType getValueBySource(String source) {
        for (ActivitySourceType sourceType : ActivitySourceType.values()) {
            if (sourceType.getSource().equals(source)) {
                return sourceType;
            }
        }
        throw new IllegalArgumentException("Enum value not found for source: " + source);
    }
}
