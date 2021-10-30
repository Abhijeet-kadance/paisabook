package com.paisabook.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paisabook.entities.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {
//	List<Transaction> findAllByTransactionTimeDateLessThanEqualAndEndDateGreaterThanEqual(Date transactionTimeDate);

	List<Transaction> findAllByTransactionTimeDateBetween  (Date startMonth,Date endMonth);
}
