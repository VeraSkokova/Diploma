package ru.nsu.ccfit.skokova.diploma.model;

public class CaseSentences {
    private String symptomString;
    private String lossString;
    private String vulnerabilityString;

    public CaseSentences() {
    }

    public CaseSentences(String symptomString, String lossString, String vulnerabilityString) {
        this.symptomString = symptomString;
        this.lossString = lossString;
        this.vulnerabilityString = vulnerabilityString;
    }

    public String getSymptomString() {
        return symptomString;
    }

    public String getLossString() {
        return lossString;
    }

    public String getVulnerabilityString() {
        return vulnerabilityString;
    }

    public void setSymptomString(String symptomString) {
        this.symptomString = symptomString;
    }

    public void setLossString(String lossString) {
        this.lossString = lossString;
    }

    public void setVulnerabilityString(String vulnerabilityString) {
        this.vulnerabilityString = vulnerabilityString;
    }
}
