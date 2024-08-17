package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.MobileDto;
import com.example.demo.service.MobileService;

import jakarta.validation.Valid;

@Controller
public class MobileController {
	
	private MobileService mobileService;
	
	public MobileController(MobileService mobileService) {
		this.mobileService = mobileService;
	}
	
	@GetMapping("/mobile/createform")
	public String newMobileRegister(Model model) {
		
		MobileDto mobileDto = new MobileDto();
		
		model.addAttribute("mobile", mobileDto);
		
		return "mobile/mobileregister";
	}
	
	@PostMapping("/mobile/save")
	public String createMobile(@Valid @ModelAttribute("mobile") MobileDto mobileDto,
			BindingResult result,
			Model model) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("mobile", mobileDto);
			return "mobile/mobileregister";
		}
		
		mobileService.saveMobile(mobileDto);

		//return "redirect:/mobile/createform";
		
		return "redirect:/mobile/createform?success";
	}
	
	/*
	@GetMapping("/mobile/mobiledropdown")
	public String displayMobileDropDown(Model model) {
		
		List<MobileDto>mobiles = null;
		
		mobiles = mobileService.findAllMobiles();
		
		model.addAttribute("mobiles", mobiles);
		
		return "mobile/mobiles";
	}
	*/
	
	@GetMapping("/mobile/mobiledropdown")
	public String displayMobileDropDown(Model model) {
		
		List<String>mobiles = null;
		
		mobiles = mobileService.findAllMobiles();
		
		model.addAttribute("mobiles", mobiles);
		
		return "mobile/mobiles";
	}
	
	
	@GetMapping("/mobile/{brandname}")
	@ResponseBody
	public List<MobileDto> getMobileInformations(@PathVariable(name = "brandname") String brandname){
		
		List<MobileDto>mobilephones = mobileService.getMobileInfoByBrand(brandname);
		
				
		return mobilephones;
		
	}

}
