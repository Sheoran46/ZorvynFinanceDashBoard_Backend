package com.example.financedashboard.repository;


import com.example.financedashboard.model.Transaction;
import com.example.financedashboard.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        List<Transaction> findByUsername(String username);

        List<Transaction> findByUserId(long userId);

        @Query("select coalesec(sum(t.amount), 0) from transactions t where t.userId=:userId and t.type=: type")
        BigDecimal findAmountByUserId(@Param("userId") long userId, @Param("type") String type);


        @Query("select t.notes, coalesec(sum(t.amount), 0) from transactions t where t.userId= : userId  group by t.notes")
        List<Object[]> findCategoryTypeAmountByUserId(@Param("userId") long userId);

        @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = :type")
        Optional<BigDecimal> sumAmountByType(TransactionType type);
}
