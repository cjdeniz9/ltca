package com.pluralsight.workbook.ii.sychronous.netflix;

public class RecommendationEngine {

    String algorithmType;
    int recommendationCount;
    boolean personalized;

    public RecommendationEngine(String algorithmType, int recommendationCount, boolean personalized) {
        this.algorithmType = algorithmType;
        this.recommendationCount = recommendationCount;
        this.personalized = personalized;
    }

    public int getRecommendationCount() {
        return recommendationCount;
    }

    public void setRecommendationCount(int recommendationCount) {
        this.recommendationCount = recommendationCount;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public boolean isPersonalized() {
        return personalized;
    }

    public void setPersonalized(boolean personalized) {
        this.personalized = personalized;
    }
}
