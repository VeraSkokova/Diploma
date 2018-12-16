package ru.nsu.ccfit.skokova.diploma.precedent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Case {
    private String name;

    private String consequence;
    @JsonProperty("consequence_cluster_id")
    private int consequenceClusterId;
    //@JsonIgnore
    @JsonProperty("consequence_mean_vector")
    private double[] consequenceMeanVector;

    private String losses;
    @JsonProperty("losses_cluster_id")
    private int lossesClusterId;
    //@JsonIgnore
    @JsonProperty("losses_mean_vector")
    private double[] lossesMeanVector;

    private String symptom;
    @JsonProperty("symptom_cluster_id")
    private int symptomClusterId;
    //@JsonIgnore
    @JsonProperty("symptom_mean_vector")
    private double[] symptomMeanVector;

    private String vulnerability;

    private String vountermeasures;

    public Case() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public int getConsequenceClusterId() {
        return consequenceClusterId;
    }

    public void setConsequenceClusterId(int consequenceClusterId) {
        this.consequenceClusterId = consequenceClusterId;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public int getLossesClusterId() {
        return lossesClusterId;
    }

    public void setLossesClusterId(int lossesClusterId) {
        this.lossesClusterId = lossesClusterId;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public int getSymptomClusterId() {
        return symptomClusterId;
    }

    public void setSymptomClusterId(int symptomClusterId) {
        this.symptomClusterId = symptomClusterId;
    }

    public String getVulnerability() {
        return vulnerability;
    }

    public void setVulnerability(String vulnerability) {
        this.vulnerability = vulnerability;
    }

    public String getVountermeasures() {
        return vountermeasures;
    }

    public void setVountermeasures(String vountermeasures) {
        this.vountermeasures = vountermeasures;
    }

    public List<Integer> toList() {
        List<Integer> clustersSet = new ArrayList<>();
        clustersSet.add(consequenceClusterId);
        clustersSet.add(lossesClusterId);
        clustersSet.add(symptomClusterId);

        return clustersSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return consequenceClusterId == aCase.consequenceClusterId &&
                lossesClusterId == aCase.lossesClusterId &&
                symptomClusterId == aCase.symptomClusterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(consequenceClusterId, lossesClusterId, symptomClusterId);
    }

    @Override
    public String toString() {
        return "Case{" +
                "consequenceClusterId=" + consequenceClusterId +
                ", lossesClusterId=" + lossesClusterId +
                ", symptomClusterId=" + symptomClusterId +
                "}\n";
    }
}
