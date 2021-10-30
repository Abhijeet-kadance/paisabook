package com.paisabook.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	private int transactionId;
	private String transactionTitle;
	private double Amount;
	private String transactionType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date transactionTimeDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd  hh:mm:ss a")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	

}
