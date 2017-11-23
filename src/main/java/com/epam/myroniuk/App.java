package com.epam.myroniuk;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.impl.dom.DomParser;
import com.epam.myroniuk.parser.impl.json.JsonParser;
import com.epam.myroniuk.parser.impl.sax.SaxParser;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class App {
    private static final String XML_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";
    private static final String JSON_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        // Parsers
        DomParser domParser = new DomParser();
        SaxParser saxParser = new SaxParser();
        JsonParser jsonParser = new JsonParser();

        // Result of DOM parsing
        List<Currency> currencies1 = domParser.parse(XML_URL);
        System.out.println("DOM Parser: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(currencies1.get(i));
        }
        System.out.println("\n ---------------------------------------- \n");

        // Result of SAX parsing
        List<Currency> currencies2 = saxParser.parse(XML_URL);
        System.out.println("SAX Parser: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(currencies2.get(i));
        }
        System.out.println("\n ---------------------------------------- \n");

        // Result of JSON parsing
        List<Currency> currencies3 = jsonParser.parse(JSON_URL);
        System.out.println("JSON Parser: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(currencies3.get(i));
        }
        System.out.println("\n ---------------------------------------- \n");
    }
}
