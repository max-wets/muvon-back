package com.ristione.muvonback.domain.entities.picture;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhotoSize {
    THUMB(180, 180),
    MEDIUM(886, 320),
    LARGE(1185, 616),
    MOBILE(798, 532);

    private final int width;
    private final int height;

    public String getSizeName() {
        return this.name().toLowerCase();
    }
}
