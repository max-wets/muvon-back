package com.ristione.muvonback.application.rest.additional_info;

import com.ristione.muvonback.domain.entities.additional_info.AdditionalInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdditionalInfoInputMapper {

    public AdditionalInfo toAdditionalInfo(AdditionalInfoInput additionalInfoInput) {
        return AdditionalInfo.builder()
                .description(additionalInfoInput.getDescription())
                .highlights(additionalInfoInput.getHighlights())
                .build();
    }
}
