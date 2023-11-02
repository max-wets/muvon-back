package com.ristione.muvonback.infrastructure.database.additional_info;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalInfoRepository extends JpaRepository<AdditionalInfoDatabase, Long> {

    @Transactional
    void deleteById(Long id);
}
