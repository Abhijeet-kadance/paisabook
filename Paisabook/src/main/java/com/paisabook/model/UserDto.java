package com.paisabook.model;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paisabook.entities.Transaction;
import com.paisabook.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString@NoArgsConstructor@AllArgsConstructor
public class UserDto {

	@JsonProperty("userId")
	private int userId;
	
	@JsonProperty("firstName")
	private String firstName;
	
//	private String middleName;
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("currentBalance")
	private double currentBalance;
	
//	@JsonProperty("transactions")
//	private List<TransactionOutDto> transactions;
	
	@Bean
	public static User toEntity(UserDto udto) {
		User entity = new User();
		BeanUtils.copyProperties(udto, entity);
		return entity;
	}
      
	public static UserDto fromEntity(User entity) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(entity, dto);
//		Stream<TransactionOutDto> transList = entity.getTransactions().stream().map(transaction -> TransactionOutDto.fromEntity(transaction));
//		dto.setTransactions((List<TransactionOutDto>) transList);
		return dto;
	}
}
