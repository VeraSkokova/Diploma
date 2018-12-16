package ru.nsu.ccfit.skokova.diploma.apriori;

import java.util.*;

/**
 * This class implements the
 * <a href="https://en.wikipedia.org/wiki/Apriori_algorithm">Apriori algorithm</a>
 * for frequent item set generation.
 */

public class AprioriFrequentItemSetGenerator<I extends Comparable<I>> {

    private static final Comparator ITEM_COMPARATOR = (o1, o2) -> ((Comparable) o1).compareTo(o2);

    /**
     * Generates the frequent item set data.
     *
     * @param transactionList the list of transactions to mine.
     * @param minimumSupport  the minimum support.
     * @return the object describing the result of this task.
     */
    public FrequentItemSetData<I> generate(List<List<I>> transactionList,
                                           double minimumSupport) {
        Objects.requireNonNull(transactionList, "The itemset list is empty.");
        checkSupport(minimumSupport);

        if (transactionList.isEmpty()) {
            return null;
        }

        // Maps each itemset to its support count. Support count is simply the
        // number of times an itemset appeares in the transaction list.
        Map<List<I>, Integer> supportCountMap = new HashMap<>();

        // Get the list of 1-itemsets that are frequent.
        List<List<I>> frequentItemList = findFrequentItems(transactionList,
                supportCountMap,
                minimumSupport);

        // Maps each 'k' to the list of frequent k-itemsets.
        Map<Integer, List<List<I>>> map = new HashMap<>();
        map.put(1, frequentItemList);

        // 'k' denotes the cardinality of itemsets processed at each iteration
        // of the following loop.
        int k = 1;

        do {
            ++k;

            // First generate the candidates.
            List<List<I>> candidateList = generateCandidates(map.get(k - 1));

            for (List<I> transaction : transactionList) {
                List<List<I>> candidateList2 = subList(candidateList,
                        transaction);

                for (List<I> itemset : candidateList2) {
                    supportCountMap.put(itemset,
                            supportCountMap.getOrDefault(itemset,
                                    0) + 1);
                }
            }

            map.put(k, getNextItemSets(candidateList,
                    supportCountMap,
                    minimumSupport,
                    transactionList.size()));

        } while (!map.get(k).isEmpty());

        return new FrequentItemSetData<>(extractFrequentItemsets(map),
                supportCountMap,
                minimumSupport,
                transactionList.size());
    }

    /**
     * This method simply concatenates all the lists of frequent itemsets into
     * one list.
     *
     * @param map the map mapping an itemset size to the list of frequent
     *            itemsets of that size.
     * @return the list of all frequent itemsets.
     */
    private List<List<I>> extractFrequentItemsets(Map<Integer, List<List<I>>> map) {
        List<List<I>> ret = new ArrayList<>();

        for (List<List<I>> itemsetList : map.values()) {
            ret.addAll(itemsetList);
        }

        return ret;
    }

    /**
     * This method gathers all the frequent candidate itemsets into a single
     * list.
     *
     * @param candidateList   the list of candidate itemsets.
     * @param supportCountMap the map mapping each itemset to its support count.
     * @param minimumSupport  the minimum support.
     * @param transactions    the total number of transactions.
     * @return a list of frequent itemset candidates.
     */
    private List<List<I>> getNextItemSets(List<List<I>> candidateList,
                                          Map<List<I>, Integer> supportCountMap,
                                          double minimumSupport,
                                          int transactions) {
        List<List<I>> ret = new ArrayList<>(candidateList.size());

        for (List<I> itemSet : candidateList) {
            if (supportCountMap.containsKey(itemSet)) {
                int supportCount = supportCountMap.get(itemSet);
                double support = 1.0 * supportCount / transactions;

                if (support >= minimumSupport) {
                    ret.add(itemSet);
                }
            }
        }

        return ret;
    }

    /**
     * Computes the list of itemsets that are all subsets of
     * {@code transaction}.
     *
     * @param candidateList the list of candidate itemsets.
     * @param transaction   the transaction to test against.
     * @return the list of itemsets that are subsets of {@code transaction}
     * itemset.
     */
    private List<List<I>> subList(List<List<I>> candidateList,
                                  List<I> transaction) {
        List<List<I>> ret = new ArrayList<>(candidateList.size());

        for (List<I> candidate : candidateList) {
            if (transaction.containsAll(candidate)) {
                ret.add(candidate);
            }
        }

        return ret;
    }

    /**
     * Generates the next candidates. This is so called F_(k - 1) x F_(k - 1)
     * method.
     *
     * @param itemsetList the list of source itemsets, each of size <b>k</b>.
     * @return the list of candidates each of size <b>k + 1</b>.
     */
    private List<List<I>> generateCandidates(List<List<I>> itemsetList) {
        List<List<I>> list = new ArrayList<>(itemsetList.size());

        for (List<I> itemset : itemsetList) {
            List<I> l = new ArrayList<>(itemset);
            l.sort(ITEM_COMPARATOR);
            list.add(l);
        }

        int listSize = list.size();

        List<List<I>> ret = new ArrayList<>(listSize);

        for (int i = 0; i < listSize; ++i) {
            for (int j = i + 1; j < listSize; ++j) {
                List<I> candidate = tryMergeItemsets(list.get(i), list.get(j));

                if (candidate != null) {
                    ret.add(candidate);
                }
            }
        }

        return ret;
    }

    /**
     * Attempts the actual construction of the next itemset candidate.
     *
     * @param itemset1 the list of elements in the first itemset.
     * @param itemset2 the list of elements in the second itemset.
     * @return a merged itemset candidate or {@code null} if one cannot be
     * constructed from the input itemsets.
     */
    private List<I> tryMergeItemsets(List<I> itemset1, List<I> itemset2) {
        int length = itemset1.size();

        for (int i = 0; i < length - 1; ++i) {
            if (!itemset1.get(i).equals(itemset2.get(i))) {
                return null;
            }
        }

        if (itemset1.get(length - 1).equals(itemset2.get(length - 1))) {
            return null;
        }

        List<I> ret = new ArrayList<>(length + 1);

        for (int i = 0; i < length - 1; ++i) {
            ret.add(itemset1.get(i));
        }

        ret.add(itemset1.get(length - 1));
        ret.add(itemset2.get(length - 1));
        return ret;
    }

    /**
     * Computes the frequent itemsets of size 1.
     *
     * @param itemsetList     the entire database of transactions.
     * @param supportCountMap the support count map to which to write the
     *                        support counts of each item.
     * @param minimumSupport  the minimum support.
     * @return the list of frequent one-itemsets.
     */
    private List<List<I>> findFrequentItems(List<List<I>> itemsetList,
                                            Map<List<I>, Integer> supportCountMap,
                                            double minimumSupport) {
        Map<I, Integer> map = new HashMap<>();

        // Count the support counts of each item.
        for (List<I> itemSet : itemsetList) {
            for (I item : itemSet) {
                List<I> tmp = new ArrayList<>(1);
                tmp.add(item);

                if (supportCountMap.containsKey(tmp)) {
                    supportCountMap.put(tmp, supportCountMap.get(tmp) + 1);
                } else {
                    supportCountMap.put(tmp, 1);
                }

                map.put(item, map.getOrDefault(item, 0) + 1);
            }
        }

        List<List<I>> frequentItemSetList = new ArrayList<>();

        for (Map.Entry<I, Integer> entry : map.entrySet()) {
            if (1.0 * entry.getValue() / map.size() >= minimumSupport) {
                List<I> itemSet = new ArrayList<>(1);
                itemSet.add(entry.getKey());
                frequentItemSetList.add(itemSet);
            }
        }

        return frequentItemSetList;
    }

    private void checkSupport(double support) {
        if (Double.isNaN(support)) {
            throw new IllegalArgumentException("The input support is NaN.");
        }

        if (support > 1.0) {
            throw new IllegalArgumentException(
                    "The input support is too large: " + support + ", " +
                            "should be at most 1.0");
        }

        if (support < 0.0) {
            throw new IllegalArgumentException(
                    "The input support is too small: " + support + ", " +
                            "should be at least 0.0");
        }
    }
}