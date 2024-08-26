package com.example.demo.mapper;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;

public class PlayerMapper {
	
	
	public static PlayerDto mapToPlayerDto (Player player) {
		
		/*
		return PostDto.builder()
				.id(post.getId())
				.title(post.getTitle())
				.url(post.getUrl())
				.content(post.getContent())
				.shortDescription(post.getShortDescription())
				.createdOn(post.getCreatedOn())
				.updatedOn(post.getUpdatedOn())
				.comments(post.getComments().stream()
					.map((comment) -> CommentMapper.mapToCommentDto(comment))	
					.collect(Collectors.toSet()))
				.build();
				
		*/
		
		return PlayerDto.builder()
				.id(player.getId())
				.playername(player.getPlayername())
				.playeremail(player.getPlayeremail())
				.password(player.getPassword())
				.build();
		
		
	}

}
