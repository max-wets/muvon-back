package com.ristione.muvonback.infrastructure.database.activity_type;

import com.ristione.muvonback.domain.entities.activity_type.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class ActivityTypeMapper {

    public static ActivityType toActivityType(ActivityTypeDatabase activityTypeDatabase) {
        return ActivityType.builder()
                .key(activityTypeDatabase.getKey())
                .label(activityTypeDatabase.getLabel())
                .build();
    }
}
