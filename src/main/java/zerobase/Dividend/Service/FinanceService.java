package zerobase.Dividend.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.Dividend.model.Company;
import zerobase.Dividend.model.Dividend;
import zerobase.Dividend.model.ScrapedResult;
import zerobase.Dividend.persist.CompanyRepository;
import zerobase.Dividend.persist.DividendRepository;
import zerobase.Dividend.persist.entity.CompanyEntity;
import zerobase.Dividend.persist.entity.DividendEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FinanceService {

    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;

    public ScrapedResult getDividendByCompanyName(String companyName) {

        // 1. 회사명을 기준으로 회사 정보 조회
        CompanyEntity company = this.companyRepository.findByName(companyName)
                                                    .orElseThrow(() -> new RuntimeException("존재하지 않는 회사명"));

        // 2. 조회 된 회사 ID로 배당금 정보 조회
        List< DividendEntity> dividendEntities = this.dividendRepository.findAllByCompanyId(company.getId());

        // 3. 결과 조합 후 반환
        List<Dividend> dividends = new ArrayList<>();
        for (var entity : dividendEntities) {
            dividends.add(Dividend.builder()
                    .date(entity.getDate())
                    .dividend(entity.getDividend())
                    .build());
        }

        return new ScrapedResult(Company.builder()
                .ticker(company.getTicker())
                .name(companyName)
                .build(),
        dividends);
    }
}
