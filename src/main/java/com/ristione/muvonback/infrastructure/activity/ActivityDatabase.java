package com.ristione.muvonback.infrastructure.activity;

import com.ristione.muvonback.domain.entities.activity.ActivitySourceType;
import com.ristione.muvonback.infrastructure.activity_type.ActivityTypeDatabase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity")
@Data
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_type_id")
    private ActivityTypeDatabase activityType;

    private String summary;
}
