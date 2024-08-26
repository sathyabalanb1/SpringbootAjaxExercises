package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
	
	private Long id;
	
	@NotEmpty
	private String playername;
	
	
	@NotEmpty(message="Email should not be empty or null")
	@Email
	private String playeremail;
	
	@NotEmpty(message="Password should not be empty")
	private String password;

}
