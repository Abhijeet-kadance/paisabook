package com.paisabook.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id 
	private int userId;
	private String firstName;
//	private String middleName;
	private String lastName;
	private double currentBalance;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<Transaction> transactions;
	
	public User() {
		this.transactions = new ArrayList<Transaction>();
	}
}
