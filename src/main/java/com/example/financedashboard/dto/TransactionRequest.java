package com.example.financedashboard.dto;

import com.example.financedashboard.model.TransactionType;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TransactionRequest(

        BigDecimal amount,
        TransactionType type,
        String notes,
        LocalDate transactiondate,
        String description
) {}
