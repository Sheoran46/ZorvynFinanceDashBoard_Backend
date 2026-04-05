package com.example.financedashboard.service;

import com.example.financedashboard.dto.DashBoardSummaryResponse;
import com.example.financedashboard.model.Transaction;
import com.example.financedashboard.model.TransactionType;
import com.example.financedashboard.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor 
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public DashBoardSummaryResponse getDashBoardSummary() {
        BigDecimal totalIncome = transactionRepository.sumAmountByType(TransactionType.INCOME)
                .orElse(BigDecimal.ZERO);

        BigDecimal totalExpenses = transactionRepository.sumAmountByType(TransactionType.EXPENSE)
                .orElse(BigDecimal.ZERO);

        BigDecimal netBalance = totalIncome.subtract(totalExpenses);

        return DashBoardSummaryResponse.builder()
                .totalIncome(totalIncome)
                .totalExpenses(totalExpenses)
                .netBalance(netBalance)
                .build();
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Transaction not found"));
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}