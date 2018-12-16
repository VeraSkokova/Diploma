package ru.nsu.ccfit.skokova.diploma.precedent;

import java.util.Objects;

public class Premise {
    private final int lossesClusterId;
    private final int symptomClusterId;

    public Premise(int lossesClusterId, int symptomClusterId) {
        this.lossesClusterId = lossesClusterId;
        this.symptomClusterId = symptomClusterId;
    }

    public int getLossesClusterId() {
        return lossesClusterId;
    }

    public int getSymptomClusterId() {
        return symptomClusterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premise premise = (Premise) o;
        return lossesClusterId == premise.lossesClusterId &&
                symptomClusterId == premise.symptomClusterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lossesClusterId, symptomClusterId);
    }

    @Override
    public String toString() {
        return "Premise{" +
                "lossesClusterId=" + lossesClusterId +
                ", symptomClusterId=" + symptomClusterId +
                '}';
    }
}
