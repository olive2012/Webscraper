package it.akademija.webscrapper;

import it.akademija.webscrapper.model.ShowUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

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
//            Elements showNames = doc.getElementsByClass("channel-item__title");
//            System.out.println("getElementsByClass ");
//            for (Element title : showNames) {
//                System.out.println(title.text());
//            }
            //time only
//            Elements channelNames5 = doc.getElementsByClass("data-block__text");
//            System.out.println("getElementsByClass ");
//            for (Element title : channelNames5) {
//                System.out.println(title.text());
//            }

            //show name + time
//            Elements channelNames6 = doc.getElementsByAttribute("data-tvprogname");
//            System.out.println("getElementsByAttribute ");
//            for (Element title : channelNames6) {
//                System.out.println(title.text());
//            }

            Elements showTimes = doc.getElementsByClass("data-block__text");
            Elements showNames = doc.getElementsByClass("channel-item__title");
            Elements rawShowData = doc.getElementsByAttribute("data-tvprogname");

//            for (Element title : rawShowData) {
//                String text = title.attributes().toString();
//                String channelName = parsingTextWithRegex(title.attributes().toString());
//                ShowUnit unit = new ShowUnit(title.text(), "", channelName);
//                //System.out.println("UNIT " + "Channel name: " + unit.getChannelName() + " Show name: " + unit.getShowName());
//            }
//            List <ShowUnit> listOfShowUnit = rawShowData
//                    .stream()
//                    .map(title -> new ShowUnit(title.text(), "", parsingTextWithRegex(title.attributes().toString())))
//                    .collect(Collectors.toList());
//
//            List <String> channelTitles = rawShowData
//                    .stream()
//                    .map(s -> parsingTextWithRegex(s.attributes().toString()))
//                    .collect(Collectors.toList());

            List<ShowUnit> testList = IntStream.range(0, showNames.size()).boxed()
                    .map(i -> new ShowUnit(showTimes.get(i).text(), showNames.get(i).text(),
                            parsingTextWithRegex(rawShowData.get(i).attributes().toString())))
                    .collect(toList());

            //System.out.println(Arrays.toString(listOfShowUnit.toArray()));
            System.out.println("testList "+ Arrays.toString(testList.toArray()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String parsingTextWithRegex(String text) {
        final String REGEX = "tvprogname\\=\\\"(.+)\\\"\\s";
        final Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(text);
        String channelName = "";
        if (matcher.find()) {
            channelName = matcher.group(1);
        }
        return channelName;
    }
}

