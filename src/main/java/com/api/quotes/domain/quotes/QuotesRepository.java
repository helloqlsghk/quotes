package com.api.quotes.domain.quotes;

import com.api.quotes.domain.quotes.dto.FindQuoteListResponseDto;
import com.api.quotes.domain.quotes.dto.SaveQuotesRequestDto;
import com.api.quotes.entity.QQuote;
import com.api.quotes.entity.Quote;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
@Slf4j
public class QuotesRepository {

    private final EntityManager em;
    private final JPAQueryFactory factory;

    private QQuote quote  = QQuote.quote;


    /**
     * 차량 견적 등록
     * @param requestDto
     */
    public void saveQuotes(SaveQuotesRequestDto requestDto) {

        em.persist(
                Quote.builder()
                        .carName(requestDto.getCarName())
                        .carPrice(requestDto.getCarPrice())
                        .deposit(requestDto.getDeposit())
                        .monthlyRent(requestDto.getMonthlyRent())
                        .annualMileage(requestDto.getAnnualMileage())
                        .contractMonths(requestDto.getContractMonths())
                        .userId(requestDto.getUserId())
                        .build()
        );

        em.flush();
    }

    /**
     * 차량 견적 요청 조회
     * @return List<FindQuoteListResponseDto>
     */
    public List<FindQuoteListResponseDto> findQuotesList(){

        return factory.select(Projections.fields(FindQuoteListResponseDto.class
                        ,quote.id
                        ,quote.carName
                        ,quote.carPrice
                        ,quote.deposit
                        ,quote.monthlyRent
                        ,quote.annualMileage
                        ,quote.contractMonths
                        ,quote.userId
                ))
                .from(quote)
                .fetch();

    }

    /**
     *
     * @param userId
     * @return List<FindQuoteListResponseDto>
     */
    public List<FindQuoteListResponseDto> findQuotesByUserId(String userId){

        return factory.select(Projections.fields(FindQuoteListResponseDto.class
                        ,quote.id
                        ,quote.carName
                        ,quote.carPrice
                        ,quote.deposit
                        ,quote.monthlyRent
                        ,quote.annualMileage
                        ,quote.contractMonths
                        ,quote.userId
                ))
                .from(quote)
                .where(quote.userId.eq(userId))
                .fetch();

    }






}
