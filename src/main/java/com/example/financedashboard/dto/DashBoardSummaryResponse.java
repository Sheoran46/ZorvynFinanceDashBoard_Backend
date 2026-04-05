package com.example.financedashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Builder

public record DashBoardSummaryResponse(

        BigDecimal totalIncome,
        BigDecimal totalExpenses,
        BigDecimal netBalance,
        Map<String, BigDecimal> categoryWiseTotals

) {}
