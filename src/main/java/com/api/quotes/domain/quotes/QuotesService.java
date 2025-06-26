package com.api.quotes.domain.quotes;

import com.api.quotes.domain.quotes.dto.FindQuoteListResponseDto;
import com.api.quotes.domain.quotes.dto.SaveQuotesRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuotesService {

    private final QuotesRepository quotesRepository;

    @Transactional
    public void saveQuotes(SaveQuotesRequestDto requestDto) {
        quotesRepository.saveQuotes(requestDto);
    }

    @Transactional
    public List<FindQuoteListResponseDto> findQuotesList(){
        return quotesRepository.findQuotesList();
    }

    @Transactional
    public List<FindQuoteListResponseDto> findQuotesByUserId(String userId){
        return quotesRepository.findQuotesByUserId(userId);
    }
}
