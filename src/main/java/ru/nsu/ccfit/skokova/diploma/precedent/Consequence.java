package ru.nsu.ccfit.skokova.diploma.precedent;

import java.util.Objects;

public class Consequence {
    private final int consequenceClusterId;

    public Consequence(int consequenceClusterId) {
        this.consequenceClusterId = consequenceClusterId;
    }

    public int getConsequenceClusterId() {
        return consequenceClusterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consequence that = (Consequence) o;
        return consequenceClusterId == that.consequenceClusterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(consequenceClusterId);
    }

    @Override
    public String toString() {
        return "Consequence{" +
                "consequenceClusterId=" + consequenceClusterId +
                '}';
    }
}