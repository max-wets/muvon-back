package com.ristione.muvonback.application.rest.activity.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityApi {

    private Long id;

    @Schema(description = "Source type of the activity supplier")
    private String type;

    @Schema(description = "Title of the activity")
    private String title;

    @Schema(description = "URL where the activity resource is located")
    private String url;

    @Schema(description = "Type of activity")
    private ActivityTypeApi activityType;

    @Schema(description = "Additional information about the activity")
    private AdditionalInfoApi additionalInfo;

    @Schema(description = "A detailed abstract of the activity")
    private String summary;
}
