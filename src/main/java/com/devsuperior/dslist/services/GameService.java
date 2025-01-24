package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
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
}
	
