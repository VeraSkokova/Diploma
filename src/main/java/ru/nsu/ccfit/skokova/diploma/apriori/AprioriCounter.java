package ru.nsu.ccfit.skokova.diploma.apriori;

import ru.nsu.ccfit.skokova.diploma.precedent.Case;
import ru.nsu.ccfit.skokova.diploma.precedent.CasesBase;

public class AprioriCounter {
    private CasesBase casesBase;

    public AprioriCounter(CasesBase casesBase) {
        this.casesBase = casesBase;
    }

    public void printSupports() {
        for (Case precedent : casesBase.getUniqueCasesWithCounter().keySet()) {
            double support = 1.0 * casesBase.getUniqueCasesWithCounter().get(precedent) / casesBase.allCasesCount();

            double consequenceSupport = 1.0 * casesBase.getConsequencesWithCounter()
                    .get(precedent.getCaseClusters().getConsequence()) / casesBase.allCasesCount();
            double confidence = support / consequenceSupport;

            double premiseSupport = 1.0 * casesBase.getPremisesWithCounter()
                    .get(precedent.getCaseClusters().getPremise()) / casesBase.allCasesCount();
            double lift = support / (premiseSupport * consequenceSupport);

            System.out.println(precedent + " " + support + " " + confidence + " " + lift);
        }
    }
}
