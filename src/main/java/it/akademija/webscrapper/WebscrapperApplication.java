package it.akademija.webscrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebscrapperApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WebscrapperApplication.class, args);
		Scraper.getDataFromURL();
	}

}
