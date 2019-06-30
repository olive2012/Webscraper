package it.akademija.webscrapper.controller;

import it.akademija.webscrapper.setvice.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/data")
public class ScrapController {

    @Autowired
    ScrapService scrapService;

    @GetMapping()
    public String getResponse() {
        return scrapService.getShowName();
    }
}
