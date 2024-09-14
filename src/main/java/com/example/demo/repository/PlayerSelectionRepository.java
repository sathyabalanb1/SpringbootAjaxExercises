package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PlayerSelection;

public interface PlayerSelectionRepository extends JpaRepository<PlayerSelection, Integer> {

}
