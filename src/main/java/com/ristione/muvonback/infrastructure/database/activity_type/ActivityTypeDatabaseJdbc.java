package com.ristione.muvonback.infrastructure.database.activity_type;

import com.ristione.muvonback.domain.entities.activity_type.ActivityType;
import com.ristione.muvonback.domain.use_cases.activity_type.ActivityTypePersistence;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ActivityTypeDatabaseJdbc implements ActivityTypePersistence {

    private final ActivityTypeRepository activityTypeRepository;
    private final ActivityTypeMapper activityTypeMapper;

    @Override
    public Optional<ActivityType> findByName(String activityTypeName) {
        return activityTypeRepository
                .findByKey(activityTypeName)
                .map(activityTypeMapper::toActivityType);
    }
}
