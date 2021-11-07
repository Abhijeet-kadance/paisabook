package com.paisabook.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.paisabook.daos.TransactionDao;
import com.paisabook.entities.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDao transactionDao;
	
	@Override
	public List<Transaction> findAll() {
		return transactionDao.findAll();
	}

	@Override
	public Transaction saveTransaction(Transaction trans) {
		return transactionDao.save(trans);
	}

//@PathVariable Map<String, String> pathVarsMap
//	String startDate = pathVarsMap.get("startDate");
//	String endDate = pathVarsMap.get("endDate");


	@Override
	public List<Transaction> findByMonth(Date startMonth, Date endMonth) {
		List<Transaction> transactions = transactionDao.findAllByTransactionTimeDateBetween(startMonth,endMonth);
		return transactions;
	}

	@Override
	public List<Transaction> getAllTransactionsByUserId(int id) {
		List<Transaction> alltransactionsByUserId = transactionDao.findByUserUserId(id).orElse(null);
		return alltransactionsByUserId ;
	}

}
