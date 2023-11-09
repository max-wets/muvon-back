package com.ristione.muvonback.infrastructure.database.activity;

import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.infrastructure.database.activity_type.ActivityTypeMapper;
import com.ristione.muvonback.infrastructure.database.additional_info.AdditionalInfoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActivityMapper {

    private final ActivityTypeMapper activityTypeMapper;

    private final AdditionalInfoMapper additionalInfoMapper;

    public Activity toActivity(ActivityDatabase activityDatabase) {
        return Activity.builder()
                .id(activityDatabase.getId())
                .type(activityDatabase.getType())
                .title(activityDatabase.getTitle())
                .url(activityDatabase.getUrl())
                .activityType(activityTypeMapper.toActivityType(activityDatabase.getActivityType()))
                .additionalInfo(additionalInfoMapper.toAdditionalInfo(activityDatabase.getAdditionalInfo()))
                .summary(activityDatabase.getSummary())
                .build();
    }

    public ActivityDatabase toActivityDatabase(Activity activity) {
        return ActivityDatabase.builder()
                .type(activity.getType())
                .title(activity.getTitle())
                .url(activity.getUrl())
                .activityType(activityTypeMapper.toActivityTypeDatabase(activity.getActivityType()))
                .additionalInfo(additionalInfoMapper.toAdditionalInfoDatabase(activity.getAdditionalInfo()))
                .summary(activity.getSummary())
                .build();
    }
}
