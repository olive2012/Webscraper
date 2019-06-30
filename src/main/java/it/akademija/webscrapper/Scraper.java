package it.akademija.webscrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Scraper {

    public void getDataFromPage() throws IOException {
        String html = "<html><head><title>Website title</title></head><body><p>Sample paragraph number 1 </p><p>Sample paragraph number 2</p></body></html>";

        Document doc = Jsoup.parse(html);
        System.out.println(doc.title());
        Elements paragraphs = doc.getElementsByTag("p");
        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }
    }

    public static void getDataFromURL() throws IOException {
        try {
            Document doc = Jsoup.connect("https://www.lrt.lt/").get();

            //show name only
            Elements showNames = doc.getElementsByClass("channel-item__title");
            System.out.println("getElementsByClass ");
            for (Element title : showNames) {
                System.out.println(title.text());
            }
            //time only
            Elements channelNames5 = doc.getElementsByClass("data-block__text");
            System.out.println("getElementsByClass ");
            for (Element title : channelNames5) {
                System.out.println(title.text());
            }

            //show name + time
            Elements channelNames = doc.getElementsByAttribute("data-tvprogname");
            System.out.println("getElementsByAttribute ");
            for (Element title : channelNames) {
                System.out.println(title.text());
            }

            Elements channelNames6 = doc.getElementsByAttribute("data-tvprogname");
            System.out.println("getElementsByAttribute ");
            for (Element title : channelNames6) {
                System.out.println(title.text());
                String text = title.attributes().toString();
                System.out.println(parsingTextWithRegex(text));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String parsingTextWithRegex(String text){
        final String REGEX = "tvprogname\\=\\\"(.+)\\\"\\s";
        final Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(text);
        String chanelName = "";
        if (matcher.find()) {
            chanelName = matcher.group(1);
        }
        return chanelName;
    }
}

