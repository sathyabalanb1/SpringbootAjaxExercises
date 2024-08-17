package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PlayerRole;

public interface PlayerRoleRepository extends JpaRepository<PlayerRole, Long> {
	
	PlayerRole findByRolename(String rolename);

}
