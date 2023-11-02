package com.ristione.muvonback.infrastructure.database;

import com.ristione.muvonback.infrastructure.database.additional_info.AdditionalInfoDatabase;
import com.ristione.muvonback.infrastructure.database.additional_info.AdditionalInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:postgresql://localhost:5432/muvon"
})
public class AdditionalInfoRepositoryTest {

    @Autowired
    private AdditionalInfoRepository additionalInfoRepository;

    @Autowired
    private TestEntityManager entityManager;

    AdditionalInfoDatabase additionalInfo;

    @BeforeEach
    public void setUp() {
        additionalInfo = AdditionalInfoDatabase.builder()
                .description("description")
                .highlights(new ArrayList<>())
                .build();

        additionalInfo.getHighlights().add("Highlight 1");
        additionalInfo.getHighlights().add("Highlight 2");
    }

    @Test
    public void testAddNewFirstHighlight() {
        AdditionalInfoDatabase savedAdditionalInfo = additionalInfoRepository.save(additionalInfo);

        savedAdditionalInfo.getHighlights().add(0, "Highlight 3");
        Optional<AdditionalInfoDatabase> updatedAdditionalInfo = additionalInfoRepository.findById(savedAdditionalInfo.getId());

        assertTrue(updatedAdditionalInfo.isPresent());
        assertNotNull(updatedAdditionalInfo.get().getId());
        assertEquals(3, updatedAdditionalInfo.get().getHighlights().size());
        assertEquals(savedAdditionalInfo.getHighlights().get(0), "Highlight 3");
    }

    @Test
    public void testRemoveLastHighlights() {
        AdditionalInfoDatabase savedAdditionalInfo = additionalInfoRepository.save(additionalInfo);

        savedAdditionalInfo.getHighlights().remove(savedAdditionalInfo.getHighlights().size() - 1);
        Optional<AdditionalInfoDatabase> updatedAdditionalInfo = additionalInfoRepository.findById(savedAdditionalInfo.getId());

        assertTrue(updatedAdditionalInfo.isPresent());
        assertNotNull(updatedAdditionalInfo.get().getId());
        assertEquals(1, updatedAdditionalInfo.get().getHighlights().size());
        assertEquals(updatedAdditionalInfo.get().getHighlights().get(0), "Highlight 1");
    }

    @Test
    public void testRemoveMiddleHighlight() {
        AdditionalInfoDatabase savedAdditionalInfo = additionalInfoRepository.save(additionalInfo);

        savedAdditionalInfo.getHighlights().add("Highlight 3");
        savedAdditionalInfo.getHighlights().add("Highlight 4");
        savedAdditionalInfo.getHighlights().remove(1);

        Optional<AdditionalInfoDatabase> updatedAdditionalInfo = additionalInfoRepository.findById(savedAdditionalInfo.getId());

        assertTrue(updatedAdditionalInfo.isPresent());
        assertNotNull(updatedAdditionalInfo.get().getId());
        assertEquals(3, updatedAdditionalInfo.get().getHighlights().size());
        assertEquals(updatedAdditionalInfo.get().getHighlights().get(1), "Highlight 3");
    }
}
