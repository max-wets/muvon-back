package com.ristione.muvonback.infrastructure.database;

import com.ristione.muvonback.infrastructure.database.location.LocationDatabase;
import com.ristione.muvonback.infrastructure.database.location.LocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:postgresql://localhost:5432/muvon"
})
public class LocationRepositoryTest {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void existingLocationCanBeFound() {
        LocationDatabase location = LocationDatabase.builder().name("London").urlPath("/london-l57/").build();

        Long locationId = entityManager.persist(location).getId();
        // Clear the context so that entities are not fetched from the first-level cache
        entityManager.clear();

        Optional<LocationDatabase> savedLocation = locationRepository.findById(locationId);

        assertThat(savedLocation).isPresent();
    }
}
