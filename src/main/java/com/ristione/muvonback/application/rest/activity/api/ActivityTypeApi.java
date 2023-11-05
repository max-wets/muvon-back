package com.ristione.muvonback.application.rest.activity.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ActivityType", description = "Type of the activity")
public class ActivityTypeApi {

    @Schema(example = "guidedTour")
    private String key;

    @Schema(example = "Guided Tour")
    private String label;
}
