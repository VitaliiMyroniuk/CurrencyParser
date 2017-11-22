package com.epam.myroniuk.parser.impl;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.CurrencyParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements CurrencyParser {
    @Override
    public List<Currency> parse(URL url) throws ParserConfigurationException, IOException, SAXException {
        List<Currency> result = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url.openStream());

        // TODO Finish an implementation

        return result;
    }
}
