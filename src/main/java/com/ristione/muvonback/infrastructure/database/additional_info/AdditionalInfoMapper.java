package com.ristione.muvonback.infrastructure.database.additional_info;

import com.ristione.muvonback.domain.entities.additional_info.AdditionalInfo;
import org.springframework.stereotype.Component;

@Component
public class AdditionalInfoMapper {

    public static AdditionalInfo toAdditionalInfo(AdditionalInfoDatabase additionalInfoDatabase) {
        return AdditionalInfo.builder()
                .description(additionalInfoDatabase.getDescription())
                .highlights(additionalInfoDatabase.getHighlights())
                .build();
    }
}
