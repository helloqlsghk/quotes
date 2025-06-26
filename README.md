# 차량 견적 API (Quotes API)

자동차 장기렌트/리스 플랫폼의 MVP 백엔드 프로젝트입니다.  
간단한 차량 견적 등록 및 조회 API를 제공합니다.

---

# 사용 기술 스택

- Java 17
- Spring Boot 3.2.5
- Spring Web
- JPA (Hibernate)
- H2 Database (In-Memory)
- Swagger UI (springdoc-openapi)

---

# 🧩 설치 및 실행 방법

## 1. Git Clone

```bash
git clone https://github.com/helloqlsghk/quotes.git
cd quotes
./gradlew bootRun 실행


혹은


2. JAR 파일 빌드
bash
복사
편집
./gradlew clean build
빌드가 완료되면 /build/libs/quotes-0.0.1-SNAPSHOT.jar 파일이 생성됩니다.

3. 서버 실행
bash
복사
편집
java -jar build/libs/quotes-0.0.1-SNAPSHOT.jar
기본 포트는 8080입니다.
실행되면 Swagger 문서를 통해 API를 바로 테스트할 수 있습니다.

Swagger API 문서 접속
서버가 실행되면 아래 주소로 접속하여 API를 확인할 수 있습니다:

http://localhost:8080/swagger-ui/index.html
