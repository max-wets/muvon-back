package com.ristione.muvonback.infrastructure.activity;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityDatabase, Long> {

    @Transactional
    void deleteById(Long id);
}
