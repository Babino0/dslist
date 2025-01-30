package com.devsuperior.dslist.controllers;


import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.services.GameListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	private final GameListService gameListService;

	public GameListController(GameListService gameListService) {
		this.gameListService = gameListService;
	}

	@GetMapping
	public List<GameListDto> findAllLists(){
		return gameListService.findAllLists();
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDto> findByList(@PathVariable Long listId){
		return gameListService.findByList(listId);
	}
}
	
	

