package zerobase.Dividend;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zerobase.Dividend.model.Company;
import zerobase.Dividend.scraper.Scraper;
import zerobase.Dividend.scraper.YahooFinanceScraper;

import java.io.IOException;

//@SpringBootApplication
public class DividendApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DividendApplication.class, args);

		Scraper scraper = new YahooFinanceScraper();
//		var result = scraper.scrap(Company.builder().ticker("O").build());
		var result = scraper.scrapCompanyByTicker("MMM");

		System.out.println(result);
	}
}
