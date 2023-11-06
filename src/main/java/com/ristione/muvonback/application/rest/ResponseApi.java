package com.ristione.muvonback.application.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApi {
    private String activityId;
    private String id;
    private List<ErrorApi> errors;
    private List<WarningApi> warnings;

    public boolean hasErrors() {
        return !CollectionUtils.isEmpty(errors);
    }
}
