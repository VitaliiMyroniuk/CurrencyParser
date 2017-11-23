package com.epam.myroniuk.parser.impl.sax;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.CurrencyParser;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class SaxParser implements CurrencyParser {
    @Override
    public List<Currency> parse(String path) throws ParserConfigurationException, SAXException, IOException {
        URL url = new URL(path);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        CurrencyHandler handler = new CurrencyHandler();
        parser.parse(url.openStream(), handler);

        return handler.getCurrencies();
    }
}
