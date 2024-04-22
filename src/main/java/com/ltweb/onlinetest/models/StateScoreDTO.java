package com.ltweb.onlinetest.models;

public class StateScoreDTO {
    private float mean;
    private float max;
    private float min;
    public StateScoreDTO(float mean, float max, float min) {
        this.mean = mean;
        this.max = max;
        this.min = min;
    }
    public float getMean() {
        return mean;
    }
    public float getMax() {
        return max;
    }
    public float getMin() {
        return min;
    }
    public void setMean(float mean) {
        this.mean = mean;
    }
    public void setMax(float max) {
        this.max = max;
    }
    public void setMin(float min) {
        this.min = min;
    }
}
