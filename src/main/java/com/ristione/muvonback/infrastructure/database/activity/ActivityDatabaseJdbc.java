package com.ristione.muvonback.infrastructure.database.activity;

import com.ristione.muvonback.domain.entities.activity.Activity;
import com.ristione.muvonback.domain.use_cases.activity.ActivityPersistence;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ActivityDatabaseJdbc implements ActivityPersistence {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final EntityManager entityManager;

    @Override
    public Optional<Activity> findActivity(Long activityId) {
        return activityRepository
                .findById(activityId)
                .map(activityMapper::toActivity);
    }

    @Override
    public Activity create(ActivityDatabase activityDatabase) {
        log.debug("Creating activity: " + activityDatabase.getTitle());
        entityManager.persist(activityDatabase);
        return activityMapper.toActivity(activityDatabase);
    }
}
