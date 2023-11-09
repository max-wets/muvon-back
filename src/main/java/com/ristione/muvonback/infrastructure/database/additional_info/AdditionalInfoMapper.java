package com.ristione.muvonback.infrastructure.database.additional_info;

import com.ristione.muvonback.domain.entities.additional_info.AdditionalInfo;
import org.springframework.stereotype.Component;

@Component
public class AdditionalInfoMapper {

    public AdditionalInfo toAdditionalInfo(AdditionalInfoDatabase additionalInfoDatabase) {
        return AdditionalInfo.builder()
                .description(additionalInfoDatabase.getDescription())
                .highlights(additionalInfoDatabase.getHighlights())
                .build();
    }

    public AdditionalInfoDatabase toAdditionalInfoDatabase(AdditionalInfo additionalInfo) {
        return AdditionalInfoDatabase.builder()
                .description(additionalInfo.getDescription())
                .highlights(additionalInfo.getHighlights())
                .build();
    }
}
