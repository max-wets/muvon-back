package com.ristione.muvonback.application.rest.activity;

import com.ristione.muvonback.application.rest.ResponseApi;
import com.ristione.muvonback.application.rest.ResponseApiMapper;
import com.ristione.muvonback.application.rest.activity.api.ActivityApi;
import com.ristione.muvonback.application.rest.activity.input.ActivityInput;
import com.ristione.muvonback.application.rest.activity.mapper.ActivityApiMapper;
import com.ristione.muvonback.application.rest.activity.mapper.ResponseApiActivityMapper;
import com.ristione.muvonback.domain.entities.CreationResultObject;
import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.domain.entities.activity.ActivityWriteResult;
import com.ristione.muvonback.domain.use_cases.activity.CreateActivity;
import com.ristione.muvonback.domain.use_cases.activity.DeleteActivity;
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
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/activities")
@AllArgsConstructor
@Slf4j
public class ActivityController {

    private final RetrieveActivity retrieveActivity;
    private final ActivityApiMapper activityApiMapper;
    private final CreateActivity createActivity;
    private final DeleteActivity deleteActivity;
    private final ResponseApiMapper responseApiMapper;
    private final ResponseApiActivityMapper responseApiActivityMapper;

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

    @PostMapping
    @Operation(summary = "Create a new activity card")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "The activity card has been successfully created"
            ),
            @ApiResponse(responseCode = "400", description = "The activity content is not valid")
    })
    public ResponseEntity<ResponseApi> createActivity(@RequestBody ActivityInput activityInput) {
        CreationResultObject<Activity> result = createActivity.run(activityInput);
        ResponseApi responseApi = responseApiMapper.toResponseApi(result);

        if (responseApi.hasErrors()) {
            return ResponseEntity.status(BAD_REQUEST).body(responseApi);
        } else {
            return ResponseEntity.status(CREATED).body(responseApi);
        }
    }

    @DeleteMapping("/{activity-id}")
    @Operation(summary = "Delete an activity")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "The activity card has been successfully deleted"
            ),
            @ApiResponse(responseCode = "404", description = "The activity could not be found")
    })
    public ResponseEntity<ResponseApi> deleteActivity(
            @PathVariable("activity-id") @Parameter(required = true) Long activityId
    ) {
        ActivityWriteResult activityWriteResult = deleteActivity.run(activityId);
        ResponseApi activityWriteResultApi = responseApiActivityMapper.toResponseApi(activityWriteResult);

        if (activityWriteResultApi.hasErrors()) {
            return ResponseEntity.status(BAD_REQUEST).body(activityWriteResultApi);
        } else {
            return ResponseEntity.ok(activityWriteResultApi);
        }
    }
}
