package ru.nsu.ccfit.skokova.diploma.precedent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasesBase {
    private Map<Case, Integer> uniqueCasesWithCounter;
    private List<Case> allCases;

    public CasesBase() {
        this.uniqueCasesWithCounter = new HashMap<>();
        this.allCases = new ArrayList<>();
    }

    public Map<Case, Integer> getUniqueCasesWithCounter() {
        return uniqueCasesWithCounter;
    }

    public List<Case> getAllCases() {
        return allCases;
    }

    public void addCase(Case precedent) {
        int value = uniqueCasesWithCounter.get(precedent) == null ? 1 : uniqueCasesWithCounter.get(precedent) + 1;
        uniqueCasesWithCounter.put(precedent, value);
        allCases.add(precedent);
    }

    public int size() {
        return uniqueCasesWithCounter.size();
    }

    public int allCasesCount() {
        return allCases.size();
    }
}
