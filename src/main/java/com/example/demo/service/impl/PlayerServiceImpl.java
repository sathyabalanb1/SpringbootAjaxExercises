package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.SelectionDto;
import com.example.demo.entity.Player;
import com.example.demo.entity.PlayerRole;
import com.example.demo.entity.PlayerSelection;
import com.example.demo.entity.SelectedPlayers;
import com.example.demo.entity.User;
import com.example.demo.mapper.PlayerMapper;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.PlayerRoleRepository;
import com.example.demo.repository.PlayerSelectionRepository;
import com.example.demo.repository.SelectedPlayersRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PlayerService;

@Service
public class PlayerServiceImpl  implements PlayerService {
	
	private PlayerRoleRepository playerRoleRepository;
	private PlayerRepository playerRepository;
	private UserRepository userRepository;
	private PlayerSelectionRepository playerSelectionRepository;
	private SelectedPlayersRepository selectedPlayersRepository;
	
	public PlayerServiceImpl(PlayerRoleRepository playerRoleRepository, PlayerRepository playerRepository,
			UserRepository userRepository, PlayerSelectionRepository playerSelectionRepository,SelectedPlayersRepository selectedPlayersRepository) {
		
		this.playerRoleRepository = playerRoleRepository;
		this.playerRepository = playerRepository;
		this.userRepository = userRepository;
		this.playerSelectionRepository = playerSelectionRepository;
		this.selectedPlayersRepository = selectedPlayersRepository;
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
	
	@Override
	public String processSelection(List<SelectionDto> selectedPlayers) {
		
		int i=0;
		
		PlayerSelection playerSelection = new PlayerSelection();
		
		while(i<selectedPlayers.size()) {
			
				
			int userId = selectedPlayers.get(i).getUserid();
			
			User user = userRepository.findById(userId).orElse(null);
			
			playerSelection.setUserid(user);
			
			playerSelectionRepository.save(playerSelection);
			
			long playerId = selectedPlayers.get(i).getPlayerid();
			
			Player player = playerRepository.findById(playerId).orElse(null);
			
			insertSelection(playerSelection,player);		
						
			i++;
		}
		
		return "Player Selection Completed Successfully";
		
		
	}
	
	public void insertSelection (PlayerSelection playerSelection, Player player) {
		
		SelectedPlayers selectedPlayers = new SelectedPlayers();
		
		selectedPlayers.setSelectionid(playerSelection);
		selectedPlayers.setPlayerid(player);
		
		selectedPlayersRepository.save(selectedPlayers);
		
		return;
		
	}
	
	
	/*
	int i=0;
	
	Orderplacement op = new Orderplacement();
	
	while(i<pd.size())
	{
		int customerid = pd.get(i).getCustomerid();
				
		Customer cus = customerrepository.findById(customerid).orElse(null);
		op.setCustomerid(cus);
		Orderplacement confirmorder = orderplacementrepository.save(op);
		
		int productid = pd.get(i).getProductid();
		
		Product product = productrepository.findById(productid).orElse(null);
		
		int quantity = pd.get(i).getRequiredquantity();
		
		insertOrder(quantity,product,confirmorder);
		
		i++;
		
	}
	
	return "Order placement successfully completed";
	
	*/
	/*
	public void insertOrder(int quantity,Product product, Orderplacement confirmorder)
	{
		Orderedproducts orderedproducts = new Orderedproducts();
		orderedproducts.setQuantity(quantity);
		orderedproducts.setProductid(product);
		orderedproducts.setOrderid(confirmorder);
		
		orderedproductsrepository.save(orderedproducts);
	}
	*/

}
