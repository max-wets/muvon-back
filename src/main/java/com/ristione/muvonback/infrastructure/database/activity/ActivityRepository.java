package com.ristione.muvonback.infrastructure.database.activity;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityDatabase, Long> {

    @Transactional
    void deleteById(Long id);

    @Override
    Optional<ActivityDatabase> findById(Long id);
}
