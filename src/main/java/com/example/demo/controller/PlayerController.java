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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;
import com.example.demo.service.PlayerService;

import jakarta.validation.Valid;

@Controller
public class PlayerController {
	
	private PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	
	@GetMapping("/player/register")
	public String showRegistrationForm(Model model) {
		PlayerDto player = new PlayerDto();
		model.addAttribute("player",player);
		return "player/playerregister";
	}
	
	/*
	 
	@PostMapping("/player/save")
	public String createPlayer(@RequestBody PlayerDto playerDto,
			BindingResult result,
			Model model) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("player", playerDto);
			return "player/playerregister";
		}
		
		System.out.println("Now we are in create player method");
		
		playerService.savePlayer(playerDto);

		//return "redirect:/mobile/createform";
		
		return "redirect:/player/register?success";
	}
	
	*/
	
	@PostMapping("/player/save")
	public String createPlayer(@Valid @ModelAttribute("player") PlayerDto playerDto,
			BindingResult result,
			Model model) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("player", playerDto);
			return "player/playerregister";
		}
		
		System.out.println("Now we are in create player method");
		
		playerService.savePlayer(playerDto);

		//return "redirect:/mobile/createform";
		
		return "redirect:/player/register?success";
	}
	
	
	@GetMapping("/form/displaydropdownbutton")
	public String displayForm(Model model) {
		
		return "player/displaydropdownbutton";
	}

	
	@GetMapping("/form/showdropdown")
	@ResponseBody
	public List<Player> showDropForm(Model model) {
		
	 List<Player>players = playerService.fetchPlayerDetails();
	 
	 System.out.println(players.get(0).getPlayername());
	 
	 return players;
		
	}
	
	
	
	/*
	@GetMapping("/form/showdropdown")
	@ResponseBody
	public ResponseEntity<List<Player>> showDropForm(Model model) {
		
	 List<Player>players = playerService.fetchPlayerDetails();
	 
	 System.out.println(players.get(0).getPlayername());
	 
	 return new ResponseEntity<>(players, HttpStatus.OK);
		
	}
	*/
	
	
	
	/*
	
	@RequestBody is used when the data is sent as JSON in the request body, which is typically the case when you use $.ajax() with contentType: "application/json".


	In your jQuery AJAX code, you're sending the form data as JSON using JSON.stringify(player) and setting contentType: "application/json". This sends the data as raw JSON in the request body.

	-------------------------------------------------------------

	@ModelAttribute does not handle JSON input; it expects form data sent in key-value pairs (e.g., playername=John&playeremail=john@example.com).

	Use @ModelAttribute with traditional form submission or adjust your AJAX call to send form data as key-value pairs (application/x-www-form-urlencoded).
	
	*/
	
	/*
	spring boot: i have a dropdown with three options. if i click option 1, it needs to display the table1 data's in table format, if i click option 2 it needs to display table2 data's in table format, if i click option 3 it needs to display the table 3 data's in table format. 
	if all three tables having different columns not having same columns.

	How to achieve this using spring boot, thymeleaf and jquery ajax.
	
	*/

}
