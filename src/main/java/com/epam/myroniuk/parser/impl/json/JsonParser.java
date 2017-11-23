package com.epam.myroniuk.parser.impl.json;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.CurrencyParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class JsonParser implements CurrencyParser {
    @Override
    public List<Currency> parse(String path) throws IOException {
        URL url = new URL(path);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(url, new TypeReference<List<Currency>>() {});
    }
}
