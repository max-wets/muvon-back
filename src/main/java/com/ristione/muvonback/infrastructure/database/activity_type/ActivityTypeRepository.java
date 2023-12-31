package com.ristione.muvonback.infrastructure.database.activity_type;

import com.ristione.muvonback.domain.entities.activity_type.ActivityTypeEnum;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityTypeDatabase, Long> {

    @Transactional
    void deleteById(Long id);

    Optional<ActivityTypeDatabase> findByKey(ActivityTypeEnum key);
}
