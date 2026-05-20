package com.pluralsight.aiornotai.models;

import com.pluralsight.aiornotai.enums.MediaType;
import com.pluralsight.aiornotai.interfaces.Detectable;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public abstract class Multimedia implements Detectable {

    private final String fileName;
    private final LocalDate creationDate;

    private final static LocalDate UNIVERSALDATE =  LocalDate.of(2022, 11, 1);

    public Multimedia(String fileName, LocalDate creationDate) {
        this.fileName = Objects.requireNonNull(fileName, "fileName cannot be null");
        this.creationDate = Objects.requireNonNull(creationDate, "creationDate cannot be null");


        if (fileName.isBlank()) {
            throw new IllegalArgumentException("fileName cannot be blank");
        }
    }

    public String getFileName() {
        return fileName.trim();
    }

    public LocalDate getCreationDate() {

        return MediaType.TEXT.getAiBreakthroughDate();

    }

    protected boolean fileNameContainsAI() {
        return fileName.toLowerCase(Locale.ROOT).contains("ai");
    }

    public LocalDate getUniversalAIBreakthroughDate() {
        return UNIVERSALDATE;
    }
    protected abstract LocalDate getAiBreakthroughDate();

    protected abstract String getMediaType();

    @Override
    public boolean isAI() {
        return fileNameContainsAI()
                && creationDate.isAfter(getAiBreakthroughDate()) && creationDate.isAfter(getUniversalAIBreakthroughDate());
    }

    @Override
    public String toString() {
        return "File name: " + getFileName() + "\n" +
                "Type: " + getMediaType() + "\n" +
                "Creation date: " + getCreationDate() + "\n" +
                "AI-generated: " + (isAI() ? "Yes" : "No");
    }
}