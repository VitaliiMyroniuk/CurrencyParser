package com.epam.myroniuk;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.impl.DOMParser;
import com.epam.myroniuk.parser.impl.JSONParser;
import com.epam.myroniuk.parser.impl.SAXParser;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        // Parsers
        DOMParser domParser = new DOMParser();
        SAXParser saxParser = new SAXParser();
        JSONParser jsonParser = new JSONParser();

        // Result of DOM parsing
        List<Currency> currencies1 = domParser.parse("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange");
        System.out.println("DOM Parser: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(currencies1.get(i));
        }
        System.out.println("\n ---------------------------------------- \n");
    }
}
