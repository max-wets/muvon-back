package com.ristione.muvonback.infrastructure.database.activity_type;

import com.ristione.muvonback.domain.entities.activity_type.ActivityType;
import com.ristione.muvonback.domain.entities.activity_type.ActivityTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class ActivityTypeMapper {

    public ActivityType toActivityType(ActivityTypeDatabase activityTypeDatabase) {
        return ActivityType.builder()
                .id(activityTypeDatabase.getId())
                .key(activityTypeDatabase.getKey())
                .label(activityTypeDatabase.getLabel())
                .build();
    }

    public ActivityTypeDatabase toActivityTypeDatabase(ActivityType activityType) {
        return ActivityTypeDatabase.builder()
                .id(activityType.getId())
                .key(ActivityTypeEnum.valueOf(activityType.getKey().name()))
                .label(activityType.getLabel())
                .build();
    }
}
