package zerobase.Dividend.scraper;

import zerobase.Dividend.model.Company;
import zerobase.Dividend.model.ScrapedResult;

public interface Scraper {
    Company scrapCompanyByTicker(String ticker);
    ScrapedResult scrap(Company company);
}
