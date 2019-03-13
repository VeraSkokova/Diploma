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
    private int consequenceClusterId = -1;
    //@JsonIgnore
    @JsonProperty("consequence_mean_vector")
    private double[] consequenceMeanVector;

    private String losses;
    @JsonProperty("losses_cluster_id")
    private int lossesClusterId = -1;
    //@JsonIgnore
    @JsonProperty("losses_mean_vector")
    private double[] lossesMeanVector;

    private String symptom;
    @JsonProperty("symptom_cluster_id")
    private int symptomClusterId = -1;
    //@JsonIgnore
    @JsonProperty("symptom_mean_vector")
    private double[] symptomMeanVector;

    private String vulnerability;
    @JsonProperty("vulnerabilitiy_cluster_id")
    private int vulnerabilityClusterId = -1;

    private String vountermeasures;
    @JsonProperty("vountermeasures_cluster_id")
    private int vountermeasuresClusterId = -1;

    private CaseClusters caseClusters;
    private AprioriValues aprioriValues;

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

    public int getVulnerabilityClusterId() {
        return vulnerabilityClusterId;
    }

    public void setVulnerabilityClusterId(int vulnerabilityClusterId) {
        this.vulnerabilityClusterId = vulnerabilityClusterId;
    }

    public int getVountermeasuresClusterId() {
        return vountermeasuresClusterId;
    }

    public void setVountermeasuresClusterId(int vountermeasuresClusterId) {
        this.vountermeasuresClusterId = vountermeasuresClusterId;
    }

    public CaseClusters getCaseClusters() {
        return caseClusters;
    }

    public void setCaseClusters(CaseClusters caseClusters) {
        this.caseClusters = caseClusters;
    }

    public AprioriValues getAprioriValues() {
        return aprioriValues;
    }

    public void setAprioriValues(AprioriValues aprioriValues) {
        this.aprioriValues = aprioriValues;
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
                symptomClusterId == aCase.symptomClusterId &&
                vulnerabilityClusterId == aCase.vulnerabilityClusterId &&
                vountermeasuresClusterId == aCase.vountermeasuresClusterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(consequenceClusterId, lossesClusterId, symptomClusterId, vulnerabilityClusterId, vountermeasuresClusterId);
    }

    @Override
    public String toString() {
        return "Case{" +
                "consequenceClusterId=" + consequenceClusterId +
                ", lossesClusterId=" + lossesClusterId +
                ", symptomClusterId=" + symptomClusterId +
                ", vulnerabilityClusterId=" + vulnerabilityClusterId +
                ", vountermeasuresClusterId=" + vountermeasuresClusterId +
                '}';
    }
}
