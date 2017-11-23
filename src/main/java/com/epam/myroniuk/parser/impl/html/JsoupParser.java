package com.epam.myroniuk.parser.impl.html;

import com.epam.myroniuk.entity.Currency;
import com.epam.myroniuk.parser.CurrencyParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitalii Myroniuk
 */
public class JsoupParser implements CurrencyParser {
    @Override
    public List<Currency> parse(String path) throws Exception {
        List<Currency> result = new ArrayList<>();
        Connection connection = Jsoup.connect(path);
        Document document = connection.get();
        // TODO realize parsing of currencies
        return result;
    }
}
