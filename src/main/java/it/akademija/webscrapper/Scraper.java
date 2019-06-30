package it.akademija.webscrapper;

import it.akademija.webscrapper.helpers.RegexHelper;
import it.akademija.webscrapper.model.ShowUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Service
public class Scraper {

//    public void getDataFromPage() throws IOException {
//        String html = "<html><head><title>Website title</title></head><body><p>Sample paragraph number 1 </p><p>Sample paragraph number 2</p></body></html>";
//
//        Document doc = Jsoup.parse(html);
//        System.out.println(doc.title());
//        Elements paragraphs = doc.getElementsByTag("p");
//        for (Element paragraph : paragraphs) {
//            System.out.println(paragraph.text());
//        }
//    }

    public List<ShowUnit>  getDataFromURL() throws IOException {
        List<ShowUnit> listOfShowUnits = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://www.lrt.lt/").get();

            Elements showTimes = doc.getElementsByClass("data-block__text");
            Elements showNames = doc.getElementsByClass("channel-item__title");
            Elements rawShowData = doc.getElementsByAttribute("data-tvprogname");

            listOfShowUnits = IntStream.range(0, showNames.size())
                    .boxed()
                    .map(i -> new ShowUnit(showTimes.get(i).text(), showNames.get(i).text(),
                            RegexHelper.parsingTextWithRegex(rawShowData.get(i).attributes().toString())))
                    .collect(toList());

            System.out.println("testList "+ Arrays.toString(listOfShowUnits.toArray()));


        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfShowUnits;
    }


}

