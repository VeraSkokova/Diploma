package ru.nsu.ccfit.skokova.diploma.precedent;

import java.util.Objects;

public class Consequence {
    private int consequenceClusterId;
    private int vountermeasuresClusterId;

    public Consequence() {
    }

    public Consequence(int consequenceClusterId, int vountermeasuresClusterId) {
        this.consequenceClusterId = consequenceClusterId;
        this.vountermeasuresClusterId = vountermeasuresClusterId;
    }

    public int getConsequenceClusterId() {
        return consequenceClusterId;
    }

    public int getVountermeasuresClusterId() {
        return vountermeasuresClusterId;
    }

    public void setConsequenceClusterId(int consequenceClusterId) {
        this.consequenceClusterId = consequenceClusterId;
    }

    public void setVountermeasuresClusterId(int vountermeasuresClusterId) {
        this.vountermeasuresClusterId = vountermeasuresClusterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consequence that = (Consequence) o;
        return consequenceClusterId == that.consequenceClusterId &&
                vountermeasuresClusterId == that.vountermeasuresClusterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(consequenceClusterId, vountermeasuresClusterId);
    }

    @Override
    public String toString() {
        return "Consequence{" +
                "consequenceClusterId=" + consequenceClusterId +
                ", vountermeasuresClusterId=" + vountermeasuresClusterId +
                '}';
    }
}
