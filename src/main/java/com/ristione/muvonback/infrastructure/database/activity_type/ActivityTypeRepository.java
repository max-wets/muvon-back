package com.ristione.muvonback.infrastructure.database.activity_type;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityTypeDatabase, Long> {

    @Transactional
    void deleteById(Long id);

    Optional<ActivityTypeDatabase> findByKey(String key);
}
