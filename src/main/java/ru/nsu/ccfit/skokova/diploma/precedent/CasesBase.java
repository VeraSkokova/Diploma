package ru.nsu.ccfit.skokova.diploma.precedent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasesBase {
    private Map<Case, Integer> uniqueCasesWithCounter;
    private Map<Premise, Integer> premisesWithCounter;
    private Map<Consequence, Integer> consequencesWithCounter;

    private List<Case> allCases;

    public CasesBase() {
        this.uniqueCasesWithCounter = new HashMap<>();
        this.premisesWithCounter = new HashMap<>();
        this.consequencesWithCounter = new HashMap<>();

        this.allCases = new ArrayList<>();
    }

    public Map<Case, Integer> getUniqueCasesWithCounter() {
        return uniqueCasesWithCounter;
    }

    public List<Case> getAllCases() {
        return allCases;
    }

    public Map<Consequence, Integer> getConsequencesWithCounter() {
        return consequencesWithCounter;
    }

    public Map<Premise, Integer> getPremisesWithCounter() {
        return premisesWithCounter;
    }

    public void addCase(Case precedent) {
        CaseClusters caseClusters =
                new CaseClusters(new Premise(precedent.getLossesClusterId(),
                        precedent.getSymptomClusterId(),
                        precedent.getVulnerabilityClusterId()),
                        new Consequence(precedent.getConsequenceClusterId(),
                                precedent.getVountermeasuresClusterId()));
        precedent.setCaseClusters(caseClusters);

        int value = uniqueCasesWithCounter.get(precedent) == null ? 1 : uniqueCasesWithCounter.get(precedent) + 1;
        uniqueCasesWithCounter.put(precedent, value);
        allCases.add(precedent);

        int premiseCounterValue = premisesWithCounter.getOrDefault(precedent.getCaseClusters().getPremise(), 0);
        premisesWithCounter.put(precedent.getCaseClusters().getPremise(), premiseCounterValue + 1);

        int consequenceCounterValue = consequencesWithCounter.getOrDefault(precedent.getCaseClusters().getConsequence(), 0);
        consequencesWithCounter.put(precedent.getCaseClusters().getConsequence(), consequenceCounterValue + 1);
    }

    public int size() {
        return uniqueCasesWithCounter.size();
    }

    public int allCasesCount() {
        return allCases.size();
    }
}
