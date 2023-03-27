### 배당금 구현 프로젝트
## 1. 프로젝트 개요
  - 이 프로젝트는 회사의 재무 정보를 검색하고, 배당금 데이터를 확인할 수 있는 RESTful 웹 서비스입니다. 주요 기능으로는 회원가입, 로그인, 회사 정보 자동 완성, 회사 검색, 회사 추가, 회사 삭제, 배당금 정보 조회 등이 있습니다. 프로젝트는 Java를 사용하여 구현되었고, Spring Boot, JPA, Redis 등의 기술이 사용되었습니다.

## 2. 주요 기술 및 라이브러리
  - Java
  - Spring Boot
  - Spring Security
  - Spring Data JPA
  - Redis
  - Jsoup (웹 스크래핑)

## 3. 프로젝트 구조
  1) Controller
    - AuthController: 회원가입 및 로그인 기능을 담당하는 컨트롤러입니다.
    - CompanyController: 회사 정보와 관련된 기능을 담당하는 컨트롤러입니다.
    - FinanceController: 재무 정보와 관련된 기능을 담당하는 컨트롤러입니다.

  2) Service
    - MemberService: 회원 관련 서비스입니다.
    - FinanceService: 재무 정보 관련 서비스입니다.
    - CompanyService: 회사 정보 관련 서비스입니다.

  3) Security
    - SecurityConfiguration: 웹 보안 설정입니다.
    - JwtAuthenticationFilter: JWT 토큰 인증 필터입니다.
    - TokenProvider: JWT 토큰을 생성하고 검증하는 기능을 담당하는 클래스입니다.

  4) Web Scraping
    - YahooFinanceScraper: Yahoo Finance에서 회사와 배당금 정보를 스크래핑하는 클래스입니다.
    
## 4. 기능 설명
 - [x] 1) 회원가입 및 로그인
    - 회원가입: 사용자는 이메일과 비밀번호를 입력하여 회원가입을 할 수 있습니다.
    - 로그인: 이메일과 비밀번호를 사용하여 로그인할 수 있습니다. 로그인에 성공하면 JWT 토큰이 발급됩니다.

 - [x] 2) 회사 정보 관련
    - 회사 검색: 사용자는 회사 이름을 입력하여 검색할 수 있습니다.
    - 회사 추가: 관리자 권한을 가진 사용자는 회사를 추가할 수 있습니다.
    - 회사 삭제: 관리자 권한을 가진 사용자는 회사를 삭제할 수 있습니다.
    - 회사 이름 자동 완성: 사용자는 회사 이름을 입력하면 자동 완성 기능을 이용하여 회사 이름을 확인할 수 있습니다.

 - [x] 3) 재무 정보 조회
    - 배당금 정보 조회: 사용자는 회사 이름을 입력하여 배당금 정보를 조회할 수 있습니다.
