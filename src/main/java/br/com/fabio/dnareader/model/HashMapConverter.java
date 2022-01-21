package br.com.fabio.dnareader.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final Logger logger = LoggerFactory.getLogger(HashMapConverter.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> dnaInfo) {

        String dnaInfoJson = null;
        try {
            dnaInfoJson = objectMapper.writeValueAsString(dnaInfo);
        } catch (final JsonProcessingException e) {
            logger.error("JSON writing error", e);
        }

        return dnaInfoJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dnaJson) {

        Map<String, Object> dnaInfo = null;
        try {
            dnaInfo = objectMapper.readValue(dnaJson, new TypeReference<Map<String, Object>>() {});
        } catch (final IOException e) {
            logger.error("JSON reading error", e);
        }

        return dnaInfo;
    }


}