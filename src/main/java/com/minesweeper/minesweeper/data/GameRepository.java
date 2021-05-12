package com.minesweeper.minesweeper.data;

import com.minesweeper.minesweeper.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
