package ru.nsu.ccfit.skokova.diploma.model;

import ru.nsu.ccfit.skokova.diploma.precedent.Case;

public class CaseHolder {
    private static final CaseHolder INSTANCE = new CaseHolder();

    private Case precedent;

    private CaseHolder() {
        precedent = new Case();
    }

    public static void setSymptom(String symptomString) {
        INSTANCE.precedent.setSymptom(symptomString);
    }

    public static void setLoss(String lossString) {
        INSTANCE.precedent.setLosses(lossString);
    }

    public static void setVulnerability(String vulnerabilityString) {
        INSTANCE.precedent.setVulnerability(vulnerabilityString);
    }

    public static String getSymptomDescription() {
        return INSTANCE.precedent.getSymptom();
    }

    public static String getLossDescription() {
        return INSTANCE.precedent.getLosses();
    }

    public static String getVulnerabilityDescrption() {
        return INSTANCE.precedent.getVulnerability();
    }
}
