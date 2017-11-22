package com.epam.myroniuk.parser;

import com.epam.myroniuk.entity.Currency;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface CurrencyParser {
    List<Currency> parse(URL url) throws ParserConfigurationException, IOException, SAXException;
}
