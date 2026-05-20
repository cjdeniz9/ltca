package com.pluralsight.aiornotai.models;

import java.time.LocalDate;

public class Video extends Multimedia {

    private static final LocalDate AI_BREAKTHROUGH_DATE = LocalDate.of(2022, 11, 30);
    private static final String MEDIA_TYPE = "Text";

    public Video(String fileName, LocalDate creationDate) {
        super(fileName, creationDate);
    }

    @Override
    protected LocalDate getAiBreakthroughDate() {
        // Text AI: ChatGPT was introduced on November 30, 2022.
        return AI_BREAKTHROUGH_DATE;
    }

    @Override
    protected String getMediaType() {
        return MEDIA_TYPE;
    }
}
