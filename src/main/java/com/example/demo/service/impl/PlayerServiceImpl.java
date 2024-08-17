package com.example.demo.service.impl;

import java.util.Arrays;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;
import com.example.demo.entity.PlayerRole;
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

}
