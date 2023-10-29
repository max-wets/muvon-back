package com.ristione.muvonback.infrastructure.location;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationDatabase, Long> {

    @Transactional
    void deleteById(Long id);
}
