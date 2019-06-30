package it.akademija.webscrapper.service;

import org.springframework.stereotype.Service;

@Service
public class ScrapService {

    public String getShowName(){

        return "Laidos pavadinimas";
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
