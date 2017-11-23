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
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        // Parsers
        DomParser domParser = new DomParser();
        SaxParser saxParser = new SaxParser();
        JsonParser jsonParser = new JsonParser();

        // Result of DOM parsing
        List<Currency> currencies1 = domParser.parse("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange");
        System.out.println("DOM Parser: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(currencies1.get(i));
        }
        System.out.println("\n ---------------------------------------- \n");

        // Result of SAX parsing
        List<Currency> currencies2 = domParser.parse("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange");
        System.out.println("SAX Parser: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(currencies2.get(i));
        }
        System.out.println("\n ---------------------------------------- \n");
    }
}
