package com.ristione.muvonback.domain.entities.activity_type;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ActivityType {
    @Enumerated(EnumType.STRING)
    private ActivityTypeEnum key;

    private String label;
}
