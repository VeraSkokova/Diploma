package ru.nsu.ccfit.skokova.diploma.precedent;

import java.util.Objects;

public class Premise {
    private int lossesClusterId;
    private int symptomClusterId;
    private int vulnerabilityClusterId;

    public Premise() {
    }

    public Premise(int lossesClusterId, int symptomClusterId, int vulnerabilityClusterId) {
        this.lossesClusterId = lossesClusterId;
        this.symptomClusterId = symptomClusterId;
        this.vulnerabilityClusterId = vulnerabilityClusterId;
    }

    public int getLossesClusterId() {
        return lossesClusterId;
    }

    public int getSymptomClusterId() {
        return symptomClusterId;
    }

    public int getVulnerabilityClusterId() {
        return vulnerabilityClusterId;
    }

    public void setLossesClusterId(int lossesClusterId) {
        this.lossesClusterId = lossesClusterId;
    }

    public void setSymptomClusterId(int symptomClusterId) {
        this.symptomClusterId = symptomClusterId;
    }

    public void setVulnerabilityClusterId(int vulnerabilityClusterId) {
        this.vulnerabilityClusterId = vulnerabilityClusterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premise premise = (Premise) o;
        return lossesClusterId == premise.lossesClusterId &&
                symptomClusterId == premise.symptomClusterId &&
                vulnerabilityClusterId == premise.vulnerabilityClusterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lossesClusterId, symptomClusterId, vulnerabilityClusterId);
    }

    @Override
    public String toString() {
        return "Premise{" +
                "lossesClusterId=" + lossesClusterId +
                ", symptomClusterId=" + symptomClusterId +
                ", vulnerabilityClusterId=" + vulnerabilityClusterId +
                '}';
    }
}
