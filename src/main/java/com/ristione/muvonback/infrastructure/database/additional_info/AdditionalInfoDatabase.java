package com.ristione.muvonback.infrastructure.database.additional_info;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "additional_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalInfoDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ElementCollection
    @CollectionTable(name = "highlight", joinColumns = @JoinColumn(name = "additional_info_id"))
    @Column(name = "description")
    private List<String> highlights;
}
