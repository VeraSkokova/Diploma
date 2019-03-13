package ru.nsu.ccfit.skokova.diploma.precedent;

import java.util.Objects;

public class CaseClusters {
    private Premise premise;
    private Consequence consequence;

    public CaseClusters() {
    }

    public CaseClusters(Premise premise, Consequence consequence) {
        this.premise = premise;
        this.consequence = consequence;
    }

    public Premise getPremise() {
        return premise;
    }

    public Consequence getConsequence() {
        return consequence;
    }

    public void setPremise(Premise premise) {
        this.premise = premise;
    }

    public void setConsequence(Consequence consequence) {
        this.consequence = consequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseClusters that = (CaseClusters) o;
        return Objects.equals(premise, that.premise) &&
                Objects.equals(consequence, that.consequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premise, consequence);
    }
}
