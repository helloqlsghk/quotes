package com.api.quotes.util.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {

    private final EntityManager em;
    private final DataSource dataSource;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        return queryFactory;
    }

    private String camelCaseToSnakeCase(String camelCase) {
        return camelCase.replaceAll("([A-Z])", "_$1").toLowerCase();
    }

}
