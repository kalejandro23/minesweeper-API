package com.minesweeper.minesweeper.business;

import com.minesweeper.minesweeper.domain.Cell;
import com.minesweeper.minesweeper.domain.Game;

public interface GameBusiness {
    Cell[][] createGame(Game game);
}
