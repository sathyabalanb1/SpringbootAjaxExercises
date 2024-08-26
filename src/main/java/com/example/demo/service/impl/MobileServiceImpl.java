package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MobileDto;
import com.example.demo.entity.Mobile;
import com.example.demo.mapper.MobileMapper;
import com.example.demo.mapper.PlayerMapper;
import com.example.demo.repository.MobileRepository;
import com.example.demo.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService{
	
	private MobileRepository mobileRepository;
	
	public MobileServiceImpl(MobileRepository mobileRepository) {
		
		this.mobileRepository = mobileRepository;
	}

	@Override
	public void saveMobile (MobileDto mobileDto) {
		
		Mobile mobile = new Mobile();
				
		mobile.setBrandname(mobileDto.getBrandname());
		mobile.setRam(mobileDto.getRam());
		mobile.setRom(mobileDto.getRom());
		mobile.setBattery(mobileDto.getBattery());
		mobile.setModel(mobileDto.getModel());
		
		mobileRepository.save(mobile);			
		
	}
	
//	public List<MobileDto> findAllMobiles(){
	
	public List<String> findAllMobiles(){
		
	//	List<Mobile> mobiles = mobileRepository.findAll();
		
	//	List<Mobile> mobiles = mobileRepository.findAllMobilesByUniqueBrand();
		
		List<String> mobiles = mobileRepository.findAllMobilesByUniqueBrand();
		
	//	return mobiles.stream().map(MobileMapper:: mapToMobileDto)
	//			.collect(Collectors.toList());
		
		return mobiles;
		
	}
	
	public List<MobileDto> getMobileInfoByBrand(String brandname){
		
		List<Mobile> mobiles = mobileRepository.findMobileByBrandname(brandname);
		
		return mobiles.stream().map(MobileMapper :: mapToMobileDto)
				.collect(Collectors.toList());
	}
	
	public List<MobileDto> getAllMobiles(){
		
		List<Mobile> mobiles = mobileRepository.findAll();
		
		return mobiles.stream().map(MobileMapper :: mapToMobileDto)
				.collect(Collectors.toList());
	}
}
