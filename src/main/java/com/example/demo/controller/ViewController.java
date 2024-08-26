package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.User;
import com.example.demo.service.MobileService;
import com.example.demo.service.PlayerService;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;


@Controller
public class ViewController {

	private UserService userService;
	
	private PlayerService playerService;
	
	private MobileService mobileService;
	
	private StudentService studentService;
	
	public ViewController(UserService userService, PlayerService playerService, MobileService mobileService, StudentService studentService) {
		this.userService = userService;
		this.playerService = playerService;
		this.mobileService = mobileService;
		this.studentService = studentService;
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		RegistrationDto user = new RegistrationDto();
		model.addAttribute("user",user);
		return "sampleregister";
	}
	
	@GetMapping("/emailexist")
	public ResponseEntity<String> checkEmailExist(@RequestParam("input") String inputemail)
	{		
		User us = userService.findByEmail(inputemail);
		
		System.out.println("Now we are in checkEmailExist method");
		
		if(us != null) {
			System.out.println("Email id found");
			return new ResponseEntity<>("Email ID Already Exist", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Email Not Found", HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping("/register/save")
	public String register(@Valid @ModelAttribute("user") RegistrationDto user,
				BindingResult result,
				Model model) {
	/*	
		User existingUser = userService.findByEmail(user.getEmail());
		
		if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null,"There is already a user with same mail id");
		}
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		
	*/	
		
		userService.saveUser(user);
		
		return "redirect:/register?success";
	}
	
	

	@GetMapping("/form/displayform")
	public String displayForm(Model model) {
		
		return "displayformbutton";
	}
	
	@GetMapping("/form/showform")
	public String showForm(Model model) {
		
		return "displayform";
	}
	
	@GetMapping("/form/displaytable")
	public String displayTable(Model model) {
		
		return "displaytablebutton";
	}
	
	@GetMapping("/form/showtable")
	public ResponseEntity<String> showTable(Model model) {
	//	System.out.println("danda naka danaku nakka");
	//	return "Now its time to render the table";
		return new ResponseEntity<>("Now its time to render the table", HttpStatus.OK);
	}
	
	@GetMapping("/form/displayalltabledropdown")
	public String displayAllTables(Model model) {
		
		return "displayalltabledropdown";
	}
	
	/*
	@GetMapping("/form/getTableData")
	public String displayTableBySelection(@RequestParam("table") String table) {
		if (table.equals("table1")) {
            return tableService.getTable1Data();
        } else if (table.equals("table2")) {
            return tableService.getTable2Data();
        } else if (table.equals("table3")) {
            return tableService.getTable3Data();
        }
        return null;
	}
	
	*/
	
	@GetMapping("/form/getTableData")
	@ResponseBody
	public List<?> displayTableBySelection(@RequestParam("table") String table) {
		
		if(table.equals("players")) {
			return playerService.getAllPlayers();
		}else if(table.equals("mobile")) {
			return mobileService.getAllMobiles();
		}else if(table.equals("student")) {
			return studentService.listAll();
		}
		
		return null;
	}

}
