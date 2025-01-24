package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

import jakarta.persistence.Column;

public class GameDto {
	private Long id;
	private String title;
	private Double score;
	private Integer year;
	private String genre;
	private String platforms;
	private String imgUrl;
	private String shortDescription;
	private String LongDescription;
	
	public GameDto() {
		
	}

	public GameDto(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		score = entity.getScore();
		year = entity.getYear();
		genre = entity.getGenre();
		platforms = entity.getPlatforms();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
		LongDescription = entity.getLongDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Double getScore() {
		return score;
	}

	public Integer getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getLongDescription() {
		return LongDescription;
	}
	
	
	
}
