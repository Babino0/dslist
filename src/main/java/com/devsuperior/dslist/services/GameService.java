package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @Transactional(readOnly = true)
    public List<GameMinDto> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDto::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        Game result = gameRepository.findById(id).get();

        return GameDto.builder()
                .id(result.getId())
                .title(result.getTitle())
                .score(result.getScore())
                .year(result.getYear())
                .genre(result.getGenre())
                .platforms(result.getPlatforms())
                .imgUrl(result.getImgUrl())
                .shortDescription(result.getShortDescription())
                .LongDescription(result.getLongDescription())
                .build();
    }
}
	
	
