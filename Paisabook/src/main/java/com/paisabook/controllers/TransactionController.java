package com.paisabook.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paisabook.entities.Transaction;
import com.paisabook.model.Response;
import com.paisabook.services.TransactionService;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionservice;
	
	
	@PostMapping("/getAllTransactions")
	public List<Transaction> findAllTransaction(){
		return transactionservice.findAll();
	}
	
	@PostMapping("/getByMonth")
	public ResponseEntity<?> findByMonth(@PathVariable Map<String, String> pathVarsMap) {
		String monthStart = pathVarsMap.get("startDate");
		String monthEnd = pathVarsMap.get("endDate");

		try {
			Date monthStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(monthStart); 
			Date monthEndDate =  new SimpleDateFormat("dd/MM/yyyy").parse(monthEnd);
			
			List<Transaction> tranList = transactionservice.findByMonth(monthStartDate, monthEndDate);
			return Response.success(tranList);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	return null;
	}  
}
