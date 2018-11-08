package ru.nsu.ccfit.skokova.diploma;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.readCases();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void readCases() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        SimpleModule simpleModule = new SimpleModule("Cases deserializer");
        simpleModule.addDeserializer(CasesBase.class, new CasesDeserializer(CasesBase.class));
        objectMapper.registerModule(simpleModule);

        File file = new File("result.json");
        //InputStream inputStream = getClass().getResourceAsStream("result.json");
        CasesBase casesBase = objectMapper.readValue(file, CasesBase.class);

        System.out.println("Unique cases: " + casesBase.size());
        System.out.println("Cases total: " + casesBase.allCasesCount());
        System.out.println("Cases: " + Arrays.toString(casesBase.getUniqueCasesWithCounter().entrySet().toArray()));
    }
}
