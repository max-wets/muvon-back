package com.ristione.muvonback.application.rest.activity.input;

import com.ristione.muvonback.application.rest.additional_info.AdditionalInfoInput;
import com.ristione.muvonback.application.rest.validator.ValidActivitySourceType;
import com.ristione.muvonback.application.rest.validator.ValidActivityType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityInput {

    @ValidActivitySourceType
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Source type of the activity supplier")
    private String type;

    @NotBlank(message = "Activity title is mandatory.")
    @Size(max = 255, message = "Activity title must not exceed 250 characters.")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Title of the activity")
    private String title;

    @NotBlank(message = "Activity URL is mandatory.")
    @Size(max = 255, message = "Activity title must not exceed 250 characters.")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "URL where the activity resource is located")
    private String url;

    @ValidActivityType
    @NotBlank(message = "Activity type is mandatory.")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Type of activity")
    private String activityType;

    @Valid
    @Schema(description = "Additional information on the activity")
    private AdditionalInfoInput additionalInfo;

    @NotBlank(message = "Activity summary is mandatory.")
    @Size(max = 255, message = "Activity summary must not exceed 250 characters.")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "A detailed abstract of the activity")
    private String summary;
}
