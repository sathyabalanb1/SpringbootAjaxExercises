package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.SelectionDto;
import com.example.demo.entity.Player;

public interface PlayerService {
	
	void savePlayer(PlayerDto playerDto);
	
	List<Player> fetchPlayerDetails();
	
	List<PlayerDto> getAllPlayers();
	
	String processSelection(List<SelectionDto> selectedPlayers);
	

}
