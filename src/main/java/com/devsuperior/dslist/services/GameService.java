package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameListRepository gameListRepository;
	@Autowired
	private GameRepository gameRepository;
	
	
	
	@Transactional(readOnly = true)		 
	public List <GameMinDto> findAll(){
		 List<Game> result = gameRepository.findAll();
		 return result.stream().map(x -> new GameMinDto(x)).toList();
	}
	
	@Transactional(readOnly = true)
	 public GameDto findById(Long id){
		 Game result = gameRepository.findById(id).get();
		 GameDto dto = new GameDto(result);
		 return dto;
	}
	
	@Transactional(readOnly = true)		 
	public List <GameListDto> findAllLists(){
		 List<GameList> result = gameListRepository.findAll();
		 return result.stream().map(x -> new GameListDto(x)).toList();
	}
}
	
