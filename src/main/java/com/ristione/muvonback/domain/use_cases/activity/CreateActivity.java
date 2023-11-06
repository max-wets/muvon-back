package com.ristione.muvonback.domain.use_cases.activity;

import com.ristione.muvonback.application.rest.activity.input.ActivityInput;
import com.ristione.muvonback.application.rest.additional_info.AdditionalInfoInputMapper;
import com.ristione.muvonback.domain.entities.CreationResultObject;
import com.ristione.muvonback.domain.entities.OperationResult;
import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.domain.entities.activity.ActivitySourceType;
import com.ristione.muvonback.domain.entities.activity_type.ActivityType;
import com.ristione.muvonback.domain.use_cases.activity_type.ActivityTypePersistence;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ristione.muvonback.domain.entities.activity.ActivityError.NO_ACTIVITY_TYPE;

@Component
@AllArgsConstructor
@Slf4j
public class CreateActivity {

    ActivityTypePersistence activityTypePersistence;
    private final AdditionalInfoInputMapper additionalInfoInputMapper;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CreateActivity.class);

    @Transactional
    public CreationResultObject<Activity> run(ActivityInput activityInput) {
        LOGGER.info("Creating new activity");

        List<OperationResult> activityErrors = new ArrayList<>();
        Optional<ActivityType> oActivityType = activityTypePersistence.findByName(activityInput.getActivityType());

        if (oActivityType.isEmpty()) {
            activityErrors.add(NO_ACTIVITY_TYPE);
        }

        if (activityErrors.isEmpty()) {
            Activity activity =
                    Activity.builder()
                            .type(ActivitySourceType.getValueBySource(activityInput.getType()))
                            .title(activityInput.getTitle())
                            .url(activityInput.getUrl())
                            .activityType(oActivityType.get())
                            .additionalInfo(additionalInfoInputMapper.toAdditionalInfo(activityInput.getAdditionalInfo()))
                            .summary(activityInput.getSummary())
                            .build();
        }
        return new CreationResultObject<>(
                null,
                null,
                activityErrors,
                List.of()
        );
    }
}
