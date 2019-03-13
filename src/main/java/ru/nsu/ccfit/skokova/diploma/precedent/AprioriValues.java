package ru.nsu.ccfit.skokova.diploma.precedent;

public class AprioriValues {
    private double support;
    private double confidence;
    private double lift;

    public AprioriValues() {
    }

    public AprioriValues(double support, double confidence, double lift) {
        this.support = support;
        this.confidence = confidence;
        this.lift = lift;
    }

    public double getSupport() {
        return support;
    }

    public double getConfidence() {
        return confidence;
    }

    public double getLift() {
        return lift;
    }

    public void setSupport(double support) {
        this.support = support;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public void setLift(double lift) {
        this.lift = lift;
    }
}
