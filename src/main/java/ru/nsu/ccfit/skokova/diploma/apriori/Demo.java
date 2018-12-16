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
        try {
            Main main = new Main();
            CasesBase casesBase = main.readCases();

            AprioriCounter aprioriCounter = new AprioriCounter(casesBase);
            aprioriCounter.printSupports();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}