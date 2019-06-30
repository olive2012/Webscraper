package it.akademija.webscrapper.service;

import it.akademija.webscrapper.Scraper;
import it.akademija.webscrapper.model.ShowUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapService {
    @Autowired
    Scraper scraper;

    public List<ShowUnit> getShowName(){
        List<ShowUnit> listOfShowUnits = new ArrayList<>();
        try {
            listOfShowUnits = scraper.getDataFromURL();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfShowUnits;
    }

}

//        String searchQuery = "Iphone 6s" ;
//
//        WebClient client = new WebClient();
//        client.getOptions().setCssEnabled(false);
//        client.getOptions().setJavaScriptEnabled(false);
//        try {
//        String searchUrl = "https://newyork.craigslist.org/search/sss?sort=rel&query=" + URLEncoder.encode(searchQuery, "UTF-8");
//        HtmlPage page = client.getPage(searchUrl);
//        }catch(Exception e){
//        e.printStackTrace();
//        }
//        }
