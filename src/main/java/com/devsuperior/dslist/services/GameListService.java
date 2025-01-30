package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAllLists() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> GameListDto.builder()
                        .name(x.getName())
                        .id(x.getId()).build())
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId) {
        List<GameMinProjection> result = gameListRepository.searchByList(listId);
        return result.stream().map(projection -> GameMinDto.builder()
                .id(projection.getId())
                .title(projection.getTitle())
                .year(projection.getYear())
                .imgUrl(projection.getImgUrl())
                .shortDescription(projection.getShortDescription())
                .build()).toList();
    }
}


