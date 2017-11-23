package com.epam.myroniuk.parser.impl.sax;

import com.epam.myroniuk.entity.Currency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CurrencyHandler extends DefaultHandler {
    private List<Currency> currencies = new ArrayList<>();
    private String textContent;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("currency")) {
            Currency currency = new Currency();
            currencies.add(currency);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        int index = currencies.size() - 1;
        switch (qName) {
            case "txt":
                currencies.get(index).setName(textContent);
                break;
            case "rate":
                currencies.get(index).setRate(Double.parseDouble(textContent));
                break;
            case "exchangedate":
                currencies.get(index).setDate(LocalDate.parse(textContent, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        textContent = String.copyValueOf(ch, start, length);
    }

}
