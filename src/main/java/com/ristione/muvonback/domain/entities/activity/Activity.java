package com.ristione.muvonback.domain.entities.activity;

import com.ristione.muvonback.domain.entities.activity_type.ActivityType;
import com.ristione.muvonback.domain.entities.additional_info.AdditionalInfo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Activity {

    private Long id;

    @Enumerated(EnumType.STRING)
    private ActivitySourceType type;

    private String title;
    private String url;
    private ActivityType activityType;
    private AdditionalInfo additionalInfo;
    private String summary;
}
