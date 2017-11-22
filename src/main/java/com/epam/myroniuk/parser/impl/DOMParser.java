package com.epam.myroniuk.parser.impl;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.CurrencyParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements CurrencyParser {
    @Override
    public List<Currency> parse(String path) throws ParserConfigurationException, IOException, SAXException {
        URL url = new URL(path);
        List<Currency> result = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url.openStream());
        NodeList nodes = document.getElementsByTagName("currency");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getElementsByTagName("txt").item(0).getTextContent();
                Double rate = Double.parseDouble(element.getElementsByTagName("rate").item(0).getTextContent());
                LocalDate date = LocalDate.parse(element.getElementsByTagName("exchangedate").item(0).getTextContent(),
                                                                            DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                Currency currency = new Currency(name, rate, date);
                result.add(currency);
            }
        }
        return result;
    }
}
