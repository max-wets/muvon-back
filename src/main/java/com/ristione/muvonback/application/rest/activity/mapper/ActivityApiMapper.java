package com.ristione.muvonback.application.rest.activity.mapper;

import com.ristione.muvonback.application.rest.activity.api.ActivityApi;
import com.ristione.muvonback.application.rest.activity.api.ActivityTypeApi;
import com.ristione.muvonback.application.rest.activity.api.AdditionalInfoApi;
import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.domain.entities.activity_type.ActivityType;
import com.ristione.muvonback.domain.entities.additional_info.AdditionalInfo;
import org.springframework.stereotype.Component;

@Component
public class ActivityApiMapper {
    public ActivityApi toActivityApi(Activity activity) {
        ActivityType activityType = activity.getActivityType();
        AdditionalInfo additionalInfo = activity.getAdditionalInfo();

        ActivityTypeApi activityTypeApi = new ActivityTypeApi(activityType.getKey().getKey(), activityType.getLabel());
        AdditionalInfoApi additionalInfoApi = new AdditionalInfoApi(additionalInfo.getDescription(), additionalInfo.getHighlights());

        return new ActivityApi(
                activity.getId(),
                activity.getType().getSource(),
                activity.getTitle(),
                activity.getUrl(),
                activityTypeApi,
                additionalInfoApi,
                activity.getSummary()
        );
    }
}
