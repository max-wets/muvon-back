package com.ristione.muvonback.application.rest.additional_info;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalInfoInput {

    @Size(max = 255, message = "Additional information description must not exceed 255 characters.")
    @Schema(
            requiredMode = Schema.RequiredMode.NOT_REQUIRED,
            description = "General description for the activity extra information")
    private String description;


    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Highlights of the activity")
    @Size(max = 5, message = "Number of highlights must not exceed 5")
    @Valid
    private List<String> highlights;
}
