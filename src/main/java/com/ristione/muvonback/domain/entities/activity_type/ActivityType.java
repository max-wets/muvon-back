package com.ristione.muvonback.domain.entities.activity_type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActivityType {
    GUIDED_TOUR("guidedTour", "Guided Tour"),
    DAY_TRIP("dayTrip", "Day trip"),
    WORKSHOP_CLASS("workshopOrClass", "Workshop or class"),
    ADVENTURE("adventure", "Adventure"),
    WATER_ACTIVITY("waterActivity", "Water activity"),
    ENTRY_TICKET("entryTicket", "Entry ticket");

    private final String key;
    private final String label;
}
