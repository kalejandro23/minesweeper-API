package com.minesweeper.minesweeper.data;

import com.minesweeper.minesweeper.domain.Cell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CellRepository extends JpaRepository<Cell, Integer> {

    Cell findAllByXAndYAndGameId(int x, int y, int gameId);
}
