package com.paisabook.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.paisabook.entities.Transaction;

public interface TransactionService {
	List<Transaction> findAll();
	Transaction saveTransaction(Transaction trans);
//	List<Transaction> findByMonth();
//	List<Transaction> findByMonth(Date startDate, Date endDate);
//	List<Transaction> findByMonth(Date transactionTimeDate);
	List<Transaction> findByMonth(Date startMonth, Date endMonth);
	List<Transaction> getAllTransactionsByUserId(int id);
}
