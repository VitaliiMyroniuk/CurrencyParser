package com.epam.myroniuk;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.CurrencyParser;
import com.epam.myroniuk.parser.impl.xml.dom.DomParser;
import com.epam.myroniuk.parser.impl.json.JacksonParser;
import com.epam.myroniuk.parser.impl.xml.sax.SaxParser;
import java.util.List;

public class App {
    private static final String XML_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";
    private static final String JSON_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    public static void main(String[] args) throws Exception {
        // Parsers
        CurrencyParser domParser = new DomParser();
        CurrencyParser saxParser = new SaxParser();
        CurrencyParser jacksonParser = new JacksonParser();

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

        // Result of Jackson parsing
        List<Currency> currencies3 = jacksonParser.parse(JSON_URL);
        System.out.println("Jackson Parser: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(currencies3.get(i));
        }
        System.out.println("\n ---------------------------------------- \n");
    }
}
