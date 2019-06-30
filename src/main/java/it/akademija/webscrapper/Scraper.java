package it.akademija.webscrapper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class Scraper {

    public static void getHTMLpage() {
        String searchQuery = "Iphone 6s";

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = "https://www.lrt.lt/" + URLEncoder.encode(searchQuery, "UTF-8");
            HtmlPage page = client.getPage(searchUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    public void getDataFromPage(HtmlPage page) {
//        List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']");
//        if (items.isEmpty()) {
//            System.out.println("No items found !");
//        } else {
//            for (HtmlElement item : items) {
//                HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//p[@class='result-info']/a"));
//
//                HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//a/span[@class='result-price']"));
//
//                String itemName = itemAnchor.asText();
//                String itemUrl = itemAnchor.getHrefAttribute();
//
//                System.out.println(String.format("Name : %s Url : %s Price : %s", itemName, itemPrice, itemUrl));
//            }
//        }
//    }
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
            Elements showNames = doc.getElementsByClass("channel-item__title");
            for (Element title : showNames) {
                System.out.println(title.text());
            }
            Elements channelNames = doc.getElementsByAttribute("data-tvprogname");
            for (Element title : channelNames) {
                System.out.println(title.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

