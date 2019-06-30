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

    public List<ShowUnit> getShowData(){
        List<ShowUnit> listOfShowUnits = new ArrayList<>();
        try {
            listOfShowUnits = scraper.getDataFromURL();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfShowUnits;
    }
}

