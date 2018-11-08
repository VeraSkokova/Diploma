package ru.nsu.ccfit.skokova.diploma;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CasesDeserializer extends StdDeserializer<CasesBase> {
    public CasesDeserializer(Class<?> aClass) {
        super(aClass);
    }

    @Override
    public CasesBase deserialize(JsonParser parser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        CasesBase casesBase = new CasesBase();

        while (!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();
            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = parser.getCurrentName();
                if (isNameAnInteger(fieldName)) {
                    jsonToken = parser.nextToken();
                    ObjectMapper objectMapper = new ObjectMapper();
                    Case precedent = objectMapper.readValue(parser, Case.class);
                    casesBase.addCase(precedent);
                }
            }
        }

        return casesBase;
    }

    private boolean isNameAnInteger(String name) {
        try {
            Integer.parseInt(name);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
