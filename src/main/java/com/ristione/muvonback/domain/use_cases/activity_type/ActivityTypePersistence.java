package com.ristione.muvonback.domain.use_cases.activity_type;

import com.ristione.muvonback.domain.entities.activity_type.ActivityType;

import java.util.Optional;

public interface ActivityTypePersistence {

    Optional<ActivityType> findByName(String activityTypeName);
}
