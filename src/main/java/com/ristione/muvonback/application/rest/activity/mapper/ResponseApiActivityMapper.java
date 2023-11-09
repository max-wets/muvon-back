package com.ristione.muvonback.application.rest.activity.mapper;

import com.ristione.muvonback.application.rest.ErrorApi;
import com.ristione.muvonback.application.rest.ResponseApi;
import com.ristione.muvonback.application.rest.WarningApi;
import com.ristione.muvonback.domain.entities.activity.ActivityWriteResult;
import org.springframework.stereotype.Component;

@Component
public class ResponseApiActivityMapper {

    public ResponseApi toResponseApi(ActivityWriteResult activityWriteResult) {
        return new ResponseApi(
                activityWriteResult.activityId().toString(),
                activityWriteResult.activityId().toString(),
                activityWriteResult.errors().stream().map(ErrorApi::new).toList(),
                activityWriteResult.warnings().stream().map(WarningApi::new).toList()
        );
    }
}
