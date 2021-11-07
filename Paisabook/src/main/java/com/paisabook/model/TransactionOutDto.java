package com.paisabook.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paisabook.entities.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString@NoArgsConstructor@AllArgsConstructor
public class TransactionOutDto {

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
	
	public static TransactionOutDto fromEntity(Transaction transaction) {
		TransactionOutDto outDto = new TransactionOutDto();
		BeanUtils.copyProperties(transaction, outDto,"user" );
		return outDto;
	}
	
}
