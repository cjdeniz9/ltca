package com.pluralsight.aiornotai.enums;

import java.time.LocalDate;

public enum MediaType {
    TEXT("Text", LocalDate.of(2022, 11, 30)),   // ChatGPT
    IMAGE("Image", LocalDate.of(2021, 1, 5)),   // DALL·E
    VIDEO("Video", LocalDate.of(2024, 2, 15));  // Sora

    private final String displayName;
    private final LocalDate aiBreakthroughDate;

    MediaType(String displayName, LocalDate aiBreakthroughDate) {
        this.displayName = displayName;
        this.aiBreakthroughDate = aiBreakthroughDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public LocalDate getAiBreakthroughDate() {
        return aiBreakthroughDate;
    }
}