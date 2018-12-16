package ru.nsu.ccfit.skokova.diploma.apriori;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class holds the result information of a data-mining task.
 * */
public class FrequentItemSetData<I> {

    private final List<List<I>> frequentItemSetList;
    private final Map<List<I>, Integer> supportCountMap;
    private final double minimumSupport;
    private final int numberOfTransactions;

    FrequentItemSetData(List<List<I>> frequentItemSetList,
                        Map<List<I>, Integer> supportCountMap,
                        double minimumSupport,
                        int transactionNumber) {
        this.frequentItemSetList = frequentItemSetList;
        this.supportCountMap = supportCountMap;
        this.minimumSupport = minimumSupport;
        this.numberOfTransactions = transactionNumber;
    }

    public List<List<I>> getFrequentItemSetList() {
        return frequentItemSetList;
    }

    public Map<List<I>, Integer> getSupportCountMap() {
        return supportCountMap;
    }

    public double getMinimumSupport() {
        return minimumSupport;
    }

    public int getTransactionNumber() {
        return numberOfTransactions;
    }

    public double getSupport(List<I> itemSet) {
        //System.out.println("Set = " + itemSet + " supportFromMap = " + supportCountMap.get(itemSet) + " transcations = " + numberOfTransactions);
        return 1.0 * supportCountMap.get(itemSet) / numberOfTransactions;
    }

    public double getSupport() {
        return 0.0;
    }
}
