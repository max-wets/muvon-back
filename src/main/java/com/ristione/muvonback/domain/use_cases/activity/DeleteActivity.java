package com.ristione.muvonback.domain.use_cases.activity;

import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.domain.entities.activity.ActivityWriteResult;
import com.ristione.muvonback.domain.entities.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class DeleteActivity {

    ActivityPersistence activityPersistence;

    public ActivityWriteResult run(Long activityId) {

        Optional<Activity> activity = activityPersistence.findActivity(activityId);
        if (activity.isEmpty()) {
            throw new NotFoundException(
                    String.format("Activity %s could not be found", activityId)
            );
        }

        activityPersistence.delete(activityId);

        return new ActivityWriteResult(activityId, List.of(), List.of());
    }
}
