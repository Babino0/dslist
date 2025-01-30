package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;

public interface GameListRepository extends JpaRepository<GameList, Long> {

	@Query("""
			    SELECT g.id AS id,
			           g.title AS title,
			           g.year AS year,
			           g.imgUrl AS imgUrl,
			           g.shortDescription AS shortDescription,
			           b.position AS position
			    FROM Game g
			    JOIN Belonging b ON b.id.game = g
			    WHERE b.id.List.id = :listId
			    ORDER BY b.position
			""")
	List<GameMinProjection> searchByList(Long listId);
}


