package com.ristione.muvonback.infrastructure.database.location;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationDatabase, Long> {

    @Transactional
    void deleteById(Long id);

    @Override
    Optional<LocationDatabase> findById(Long id);
}
