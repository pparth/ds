package com.odesk.directoryservice.representations;

public class ApplicantRecommendation {
    private long application_id;
    private String algorithm;
    private float score;
    private int annotation;

    public ApplicantRecommendation() {


    }

    public long getApplication_id() {
        return application_id;
    }

    public void setApplication_id(long application_id) {
        this.application_id = application_id;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getAnnotation() {
        return annotation;
    }

    public void setAnnotation(int annotation) {
        this.annotation = annotation;
    }
}