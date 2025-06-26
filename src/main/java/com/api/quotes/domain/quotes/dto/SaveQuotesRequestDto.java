package com.api.quotes.domain.quotes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "차량 견적 등록 요청 DTO")
public class SaveQuotesRequestDto {

    @Schema(description = "차량명" , example = "쏘렌토")
    @NotEmpty
    private String carName;

    @Schema(description = "차량가액" , example = "41000000")
    @NotEmpty
    private Integer carPrice;

    @Schema(description = "보증금" , example = "10000000")
    @NotEmpty
    private Integer deposit;

    @Schema(description = "월 렌트료" , example = "470000")
    @NotEmpty
    private Integer monthlyRent;

    // 약정거리 (예: 20000)
    @Schema(description = "약정거리" , example = "20000")
    @NotEmpty
    private Integer annualMileage;

    // 계약기간 (48 또는 60)
    @Schema(description = "계약기간" , example = "60")
    @NotEmpty
    private Integer contractMonths;

    // 사용자 ID
    @Schema(description = "사용자ID" , example = "quotevisitor")
    @NotEmpty
    private String userId;
}
