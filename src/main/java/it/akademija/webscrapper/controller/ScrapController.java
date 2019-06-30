package it.akademija.webscrapper.controller;

import it.akademija.webscrapper.model.ShowUnit;
import it.akademija.webscrapper.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/data")
public class ScrapController {

    @Autowired
    ScrapService scrapService;

    @GetMapping()
    public List<ShowUnit> getResponse() {
        return scrapService.getShowData();
    }
}
