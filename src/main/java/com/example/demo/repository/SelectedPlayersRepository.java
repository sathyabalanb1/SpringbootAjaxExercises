package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SelectedPlayers;

public interface SelectedPlayersRepository extends JpaRepository<SelectedPlayers,Integer> {

}
