package com.example.demo.mapper;

import com.example.demo.dto.MobileDto;
import com.example.demo.entity.Mobile;



public class MobileMapper {
	
	public static MobileDto mapToMobileDto(Mobile mobile) {
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
		
		return MobileDto.builder()
				.id(mobile.getId())
				.model(mobile.getModel())
				.brandname(mobile.getBrandname())
				.ram(mobile.getRam())
				.rom(mobile.getRom())
				.battery(mobile.getBattery())
				.createdOn(mobile.getCreatedOn())
				.updatedOn(mobile.getUpdatedOn())
				.build();
	}

}
