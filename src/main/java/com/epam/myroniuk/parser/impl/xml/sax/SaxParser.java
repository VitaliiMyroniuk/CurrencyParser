package com.epam.myroniuk.parser.impl.xml.sax;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.CurrencyParser;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.util.List;

public class SaxParser implements CurrencyParser {
    @Override
    public List<Currency> parse(String path) throws Exception {
        URL url = new URL(path);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        CurrencyHandler handler = new CurrencyHandler();
        parser.parse(url.openStream(), handler);
        return handler.getCurrencies();
    }
}
