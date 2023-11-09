package com.ristione.muvonback.domain.use_cases.activity;

import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.infrastructure.database.activity.ActivityDatabase;

import java.util.Optional;

public interface ActivityPersistence {

    Optional<Activity> findActivity(Long activityId);

    Activity create(ActivityDatabase activityDatabase);
}
