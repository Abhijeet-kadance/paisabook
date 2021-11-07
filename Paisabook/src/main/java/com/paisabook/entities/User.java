package com.paisabook.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id 
	private int userId;
	private String firstName;
//	private String middleName;
	private String lastName;
	private double currentBalance;
	
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	
	public User() {
		this.transactions = new ArrayList<Transaction>();
	}
}
