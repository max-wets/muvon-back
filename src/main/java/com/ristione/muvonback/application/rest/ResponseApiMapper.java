package com.ristione.muvonback.application.rest;

import com.ristione.muvonback.domain.entities.CreationResultObject;
import com.ristione.muvonback.domain.entities.activity.Activity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ResponseApiMapper {

    public ResponseApi toResponseApi(CreationResultObject<?> creationResultObject) {
        if (creationResultObject.object() instanceof Activity) {
            return new ResponseApi(
                    creationResultObject.activityId(),
                    creationResultObject.activityId(),
                    creationResultObject.errors().stream().map(ErrorApi::new).toList(),
                    creationResultObject.warnings().stream().map(WarningApi::new).toList()
            );
        }
        return new ResponseApi();
    }
}
