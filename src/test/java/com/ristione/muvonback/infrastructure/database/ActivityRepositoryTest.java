package com.ristione.muvonback.infrastructure.database;

import com.ristione.muvonback.domain.entities.activity.ActivitySourceType;
import com.ristione.muvonback.domain.entities.activity_type.ActivityType;
import com.ristione.muvonback.infrastructure.database.activity.ActivityDatabase;
import com.ristione.muvonback.infrastructure.database.activity.ActivityRepository;
import com.ristione.muvonback.infrastructure.database.activity_type.ActivityTypeDatabase;
import com.ristione.muvonback.infrastructure.database.additional_info.AdditionalInfoDatabase;
import com.ristione.muvonback.infrastructure.database.additional_info.AdditionalInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:postgresql://localhost:5432/muvon"
})
public class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private AdditionalInfoRepository additionalInfoRepository;

    @Autowired
    private TestEntityManager entityManager;

    private ActivityDatabase activity;

    @BeforeEach()
    public void setUp() {
        ActivityTypeDatabase activityType =
                ActivityTypeDatabase.builder()
                        .key(ActivityType.GUIDED_TOUR)
                        .label(ActivityType.GUIDED_TOUR.getLabel())
                        .build();
        AdditionalInfoDatabase additionalInfo =
                AdditionalInfoDatabase.builder()
                        .description("Activity description")
                        .highlights(Arrays.asList("Highlight 1", "Highlight 2"))
                        .build();

        activity = ActivityDatabase.builder()
                .type(ActivitySourceType.SUPPLIER_ACTIVITY)
                .title("title")
                .url("url")
                .activityType(activityType)
                .additionalInfo(additionalInfo)
                .summary("summary description")
                .build();
    }

    @Test
    public void testCreateActivityWithAdditionalInfo() {

        ActivityDatabase savedActivity = activityRepository.save(activity);

        assertNotNull(savedActivity.getId());
        assertNotNull(savedActivity.getAdditionalInfo().getId());
        assertEquals(savedActivity.getActivityType().getKey(), ActivityType.GUIDED_TOUR);
        assertEquals(2, savedActivity.getAdditionalInfo().getHighlights().size());
    }

    @Test
    public void testDeleteActivityWithAdditionalInfo() {
        ActivityDatabase savedActivity = activityRepository.save(activity);

        assertNotNull(savedActivity.getId());
        assertNotNull(savedActivity.getAdditionalInfo().getId());

        activityRepository.deleteById(savedActivity.getId());

        assertNull(activityRepository.findById(savedActivity.getId()).orElse(null));
        assertNull(additionalInfoRepository.findById(savedActivity.getAdditionalInfo().getId()).orElse(null));
    }
}
