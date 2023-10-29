package com.ristione.muvonback.infrastructure.activity_type;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityTypeDatabase, Long> {

    @Transactional
    void deleteById(Long id);
}
