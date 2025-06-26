package com.api.quotes.domain.quotes.dto;

import lombok.Data;

@Data
public class SaveQuotesResponseDto {

    // ID
    private Long id;

    // 차량명 쏘렌토
    private String carName;

    // 차량가액 (예: 41000000)
    private Integer carPrice;

    // 보증금 (예: 10000000)
    private Integer deposit;

    // 월 렌트료 (예: 470000)
    private Integer monthlyRent;

    // 약정거리 (예: 20000)
    private Integer annualMileage;

    // 계약기간 (48 또는 60)
    private Integer contractMonths;

    // 사용자 ID
    private String userId;

}
