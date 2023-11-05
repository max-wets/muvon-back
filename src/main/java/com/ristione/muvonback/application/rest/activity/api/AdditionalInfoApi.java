package com.ristione.muvonback.application.rest.activity.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "AdditionalInfo", description = "Extra details about the activity")
public class AdditionalInfoApi {

    @Schema(description = "general description, if need be",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String description;

    @Schema(description = "highlights of the activity")
    private List<String> highlights;
}
