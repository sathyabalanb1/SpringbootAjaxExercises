package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;
import com.example.demo.entity.PlayerRole;
import com.example.demo.mapper.PlayerMapper;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.PlayerRoleRepository;
import com.example.demo.service.PlayerService;

@Service
public class PlayerServiceImpl  implements PlayerService {
	
	private PlayerRoleRepository playerRoleRepository;
	private PlayerRepository playerRepository;
	
	public PlayerServiceImpl(PlayerRoleRepository playerRoleRepository, PlayerRepository playerRepository) {
		
		this.playerRoleRepository = playerRoleRepository;
		this.playerRepository = playerRepository;
	}
	
	@Override
	public void savePlayer (PlayerDto playerDto) {
		
		Player player = new Player();
		
		player.setPlayername(playerDto.getPlayername());
		player.setPlayeremail(playerDto.getPlayeremail());
		player.setPassword(playerDto.getPassword());
		
		PlayerRole playerrole = playerRoleRepository.findByRolename("ROLE_BATSMAN");
		
		player.setPlayerroles(Arrays.asList(playerrole));
		
		playerRepository.save(player);
		
		return;
		
	}
	
	@Override
	public List<Player> fetchPlayerDetails () {
		
		return playerRepository.findAll();
	}
	
	public List<PlayerDto> getAllPlayers(){
		
		List<Player> players = playerRepository.findAll();
		
		return players.stream().map(PlayerMapper :: mapToPlayerDto)
				.collect(Collectors.toList());
	}

}
