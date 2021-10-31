package com.paisabook.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "expense")
public class Expense {
	
	@Id
	private int expenseId;
	private String expenseTitle;
	private double expenseAmount;
}
