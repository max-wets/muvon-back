package com.ristione.muvonback.domain.use_cases.activity;

import com.ristione.muvonback.domain.entities.activity.Activity;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class RetrieveActivity {

    ActivityPersistence activityPersistence;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(RetrieveActivity.class);

    public Activity run(Long activityId) throws ClassNotFoundException, IllegalArgumentException {
        LOGGER.info("Retrieving activity card with id " + activityId);

        if (activityId == null || activityId <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer");
        }

        Optional<Activity> oActivity = activityPersistence.findActivity(activityId);

        if (oActivity.isPresent()) {
            return oActivity.get();
        } else {
            throw new ClassNotFoundException("The activity with ID: " + activityId + " has not been found.");
        }
    }
}
