package com.ristione.muvonback.application.rest.activity;

import com.ristione.muvonback.application.rest.activity.api.ActivityApi;
import com.ristione.muvonback.application.rest.activity.mapper.ActivityApiMapper;
import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.domain.use_cases.activity.RetrieveActivity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/activities")
@AllArgsConstructor
@Slf4j
public class ActivityController {

    private final RetrieveActivity retrieveActivity;
    private final ActivityApiMapper activityApiMapper;

    @GetMapping("/{activity-id}")
    @Operation(summary = "Get a complete activity card from its ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "The activity card has been successfully retrieved",
                    content = @Content(schema = @Schema(implementation = ActivityApi.class))
            ),
            @ApiResponse(responseCode = "404", description = "The activity has not been found")
    })
    public ResponseEntity<ActivityApi> getActivity(
            @PathVariable("activity-id")
            @Parameter(required = true)
            @Min(value = 1, message = "ID must be a positive integer")
            Long activityId
    ) {
        try {
            Activity activity = retrieveActivity.run(activityId);
            ActivityApi activityApi = activityApiMapper.toActivityApi(activity);

            return ResponseEntity.status(OK).body(activityApi);
        } catch (IllegalArgumentException | ClassNotFoundException ex) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
}
