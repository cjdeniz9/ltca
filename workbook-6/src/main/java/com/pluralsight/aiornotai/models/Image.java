package com.pluralsight.aiornotai.models;

import java.time.LocalDate;
import java.util.Objects;

import com.pluralsight.aiornotai.enums.MediaType;

public class Image extends Multimedia {

    private static final LocalDate AI_BREAKTHROUGH_DATE = LocalDate.of(2021, 1, 5);
    private static MediaType mediatype;

    public Image(String fileName, LocalDate creationDate) {
        super(fileName,creationDate);


    }

    @Override
    protected LocalDate getAiBreakthroughDate() {
        // Image AI: DALL·E was introduced on January 5, 2021.
        return AI_BREAKTHROUGH_DATE;
    }

    @Override
    protected String getMediaType() {
        return MediaType.IMAGE.getDisplayName();
    }
}
