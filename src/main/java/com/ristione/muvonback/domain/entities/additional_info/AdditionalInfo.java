package com.ristione.muvonback.domain.entities.additional_info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class AdditionalInfo {
    private String description;
    private List<String> highlights;
}
