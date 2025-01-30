package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GameMinDto {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;


    public GameMinDto(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.year = game.getYear();
        this.imgUrl = game.getImgUrl();
        this.shortDescription = game.getShortDescription();
    }

}
