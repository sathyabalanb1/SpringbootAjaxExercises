package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MobileDto;

public interface MobileService {
	
	void saveMobile(MobileDto mobileDto);
	
//	List<MobileDto> findAllMobiles();
	
	List<String> findAllMobiles();
	
	List<MobileDto> getMobileInfoByBrand(String brandname);
	
	List<MobileDto> getAllMobiles();

}
