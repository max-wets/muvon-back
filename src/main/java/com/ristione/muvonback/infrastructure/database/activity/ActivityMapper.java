package com.ristione.muvonback.infrastructure.database.activity;

import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.infrastructure.database.activity_type.ActivityTypeMapper;
import com.ristione.muvonback.infrastructure.database.additional_info.AdditionalInfoMapper;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {

    public Activity toActivity(ActivityDatabase activityDatabase) {

        return Activity.builder()
                .id(activityDatabase.getId())
                .type(activityDatabase.getType())
                .title(activityDatabase.getTitle())
                .url(activityDatabase.getUrl())
                .activityType(ActivityTypeMapper.toActivityType(activityDatabase.getActivityType()))
                .additionalInfo(AdditionalInfoMapper.toAdditionalInfo(activityDatabase.getAdditionalInfo()))
                .summary(activityDatabase.getSummary())
                .build();
    }
}
