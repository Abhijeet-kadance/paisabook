package com.paisabook.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paisabook.entities.Transaction;
import com.paisabook.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString@NoArgsConstructor@AllArgsConstructor
public class TransactionDto {

	@JsonProperty("transactionId")
	private int transactionId;
	
	@JsonProperty("transactionTitle")
	private String transactionTitle;
	
	@JsonProperty("Amount")
	private double Amount;
	
	@JsonProperty("transactionType")
	private String transactionType;
	
	@JsonProperty("transactionTimeDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date transactionTimeDate;
	
	@JsonProperty("createdAt")
	@DateTimeFormat(pattern = "yyyy-MM-dd  hh:mm:ss a")
	@Temporal(TemporalType.TIMESTAMP)
	private String createdAt;
	
	@JsonProperty("userId")
	private int userId;
	
	
	public static Transaction toEntity(TransactionDto transactiondto) {
		Transaction entity = new Transaction();
//		SimpleDateFormat formatter5=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");  
//		try {
//			Date date5=formatter5.parse(transactiondto.createdAt);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}  
		BeanUtils.copyProperties(transactiondto, entity ,"userId");
		User u = new User();
		u.setUserId(transactiondto.getUserId());
		entity.setUser(u);
		return entity;
	}
	
	public static TransactionDto fromEntity(Transaction transaction) {
		TransactionDto dto = new TransactionDto();
		BeanUtils.copyProperties(transaction, dto );
		return dto;
	}
}
