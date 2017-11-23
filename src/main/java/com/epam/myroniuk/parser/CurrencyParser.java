package com.epam.myroniuk.parser;

import com.epam.myroniuk.entity.Currency;
import java.util.List;

public interface CurrencyParser {
    List<Currency> parse(String path) throws Exception;
}
