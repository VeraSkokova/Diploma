package ru.nsu.ccfit.skokova.diploma.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nsu.ccfit.skokova.diploma.precedent.Case;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CaseSender {
    private String host;
    private int port;

    public static void main(String[] args) {
        CaseSender caseSender = new CaseSender("127.0.0.1", 4569);
        caseSender.send(new CaseSentences("I love http", "I need https", "Browser"));
    }

    public CaseSender(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void send(CaseSentences caseSentences) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
        objectMapper.configure(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM, true);
        objectMapper.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);

        try (Socket socket = new Socket(host, port);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            objectMapper.writeValue(outputStream, caseSentences);

            /*byte[] caseBytes = (byte[]) inputStream.readObject();
            String caseString = new String(caseBytes, StandardCharsets.UTF_8);

            Case precedent = objectMapper.readValue(caseString, Case.class);*/

            Case precedent = objectMapper.readValue(inputStream, Case.class);
            System.out.println(precedent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
