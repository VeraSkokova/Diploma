package ru.nsu.ccfit.skokova.diploma.deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ru.nsu.ccfit.skokova.diploma.precedent.CasesBase;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.readCases();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public CasesBase readCases() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        SimpleModule simpleModule = new SimpleModule("Cases deserializer");
        simpleModule.addDeserializer(CasesBase.class, new CasesDeserializer(CasesBase.class));
        objectMapper.registerModule(simpleModule);

        File file = new File("result.json");
        CasesBase casesBase = objectMapper.readValue(file, CasesBase.class);

        System.out.println("Unique cases: " + casesBase.size());
        System.out.println("Cases total: " + casesBase.allCasesCount());
        System.out.println("Cases: " + Arrays.toString(casesBase.getUniqueCasesWithCounter().entrySet().toArray()));

        int sum = casesBase.getUniqueCasesWithCounter()
                .entrySet()
                .stream()
                .mapToInt(Map.Entry::getValue)
                .sum();

        System.out.println("Sum = " + sum);

        int max = casesBase.getUniqueCasesWithCounter()
                .entrySet()
                .stream()
                .mapToInt(Map.Entry::getValue)
                .max()
                .getAsInt();

        System.out.println("Max = " + max);

        return casesBase;
    }
}
