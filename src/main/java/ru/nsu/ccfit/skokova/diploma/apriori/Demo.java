package ru.nsu.ccfit.skokova.diploma.apriori;

import ru.nsu.ccfit.skokova.diploma.deserializer.Main;
import ru.nsu.ccfit.skokova.diploma.precedent.Case;
import ru.nsu.ccfit.skokova.diploma.precedent.CasesBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        /*AprioriFrequentItemSetGenerator<Integer> generator =
                new AprioriFrequentItemSetGenerator<>();*/

        try {
            Main main = new Main();
            CasesBase casesBase = main.readCases();

            /*List<Case> casesList = new ArrayList<>(casesBase.getAllCases());

            FrequentItemSetData<Integer> data = generator.generate(casesList.stream()
                    .map(Case::toList)
                    .collect(Collectors.toList()), 0.0);
            int i = 1;

            for (List<Integer> itemSet : data.getFrequentItemSetList()) {
                System.out.printf("%2d: %9s, support: %1.8f\n",
                        i++,
                        itemSet,
                        data.getSupport(itemSet));
            }

            System.out.println();*/

            AprioriCounter aprioriCounter = new AprioriCounter(casesBase);
            aprioriCounter.printSupports();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        /*AprioriFrequentItemSetGenerator<String> generator =
                new AprioriFrequentItemSetGenerator<>();

        List<Set<String>> itemSetList = new ArrayList<>();

        itemSetList.add(new HashSet<>(Arrays.asList("a", "b")));
        itemSetList.add(new HashSet<>(Arrays.asList("b", "c", "d")));
        itemSetList.add(new HashSet<>(Arrays.asList("a", "c", "d", "e")));
        itemSetList.add(new HashSet<>(Arrays.asList("a", "d", "e")));
        itemSetList.add(new HashSet<>(Arrays.asList("a", "b", "c")));

        itemSetList.add(new HashSet<>(Arrays.asList("a", "b", "c", "d")));
        itemSetList.add(new HashSet<>(Arrays.asList("a")));
        itemSetList.add(new HashSet<>(Arrays.asList("a", "b", "c")));
        itemSetList.add(new HashSet<>(Arrays.asList("a", "b", "d")));
        itemSetList.add(new HashSet<>(Arrays.asList("b", "c", "e")));

        FrequentItemSetData<String> data = generator.generate(itemSetList, 0.2);
        int i = 1;

        for (Set<String> itemSet : data.getFrequentItemSetList()) {
            System.out.printf("%2d: %9s, support: %1.1f\n",
                    i++,
                    itemSet,
                    data.getSupport(itemSet));
        }*/
    }
}