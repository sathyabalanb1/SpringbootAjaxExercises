package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobileDto {
	
	
	private Long id;
	
	@NotEmpty(message ="Brand name should not be empty")
	private String brandname;
	
	@NotEmpty(message ="Model name should not be empty")
	private String model;
	
	@NotEmpty(message ="RAM size should not be empty")
	private String ram;
	
	@NotEmpty(message ="ROM size should not be empty")
	private String rom;
	
	@NotEmpty(message ="Battery size should not be empty")
	private String battery;
		
	@CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;


}
