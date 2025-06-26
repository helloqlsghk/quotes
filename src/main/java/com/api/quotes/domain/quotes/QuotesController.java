package com.api.quotes.domain.quotes;

import com.api.quotes.domain.quotes.dto.SaveQuotesRequestDto;
import com.api.quotes.util.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
@RequiredArgsConstructor
@Tag(name = "1. Quotes 차량견적", description = "차량 견적을 등록 및 조회한다.")
public class QuotesController {

    private final QuotesService quotesService;

    @PostMapping("/quotes")
    @Operation(summary = "1. 차량 견적 등록", description = "입력된 정보로 차량 견적을 등록한다.")
    public CommonResponse<?> saveQuotes(@RequestBody SaveQuotesRequestDto saveQuotesRequestDto) {
        quotesService.saveQuotes(saveQuotesRequestDto);
        return new CommonResponse<>("등록이 정상적으로 처리되었습니다.");
    }

    @GetMapping("/quotes")
    @Operation(summary = "2. 차량 견적 조회", description = "전체 차량 견적을 조회한다.")
    public CommonResponse<?> findQuotesList() {
        // 조회 로직
        return new CommonResponse<>(quotesService.findQuotesList());
    }

    @GetMapping("/quotes/user/{userId}")
    @Operation(summary = "3. 차량 견적 조건 조회", description = "userId 기준으로 차량을 조회한다.")
    public CommonResponse<?> findQuotesByUserId(@PathVariable String userId){

        return new CommonResponse<>(quotesService.findQuotesByUserId(userId));
    }


}
