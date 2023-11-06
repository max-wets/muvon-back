package com.ristione.muvonback.infrastructure.database.activity;

import com.ristione.muvonback.domain.entities.activity.ActivitySourceType;
import com.ristione.muvonback.infrastructure.database.activity_type.ActivityTypeDatabase;
import com.ristione.muvonback.infrastructure.database.additional_info.AdditionalInfoDatabase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ActivitySourceType type;

    private String title;
    private String url;

    @ManyToOne
    @JoinColumn(name = "activity_type_id")
    private ActivityTypeDatabase activityType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "additional_info_id")
    private AdditionalInfoDatabase additionalInfo;

    private String summary;
}
