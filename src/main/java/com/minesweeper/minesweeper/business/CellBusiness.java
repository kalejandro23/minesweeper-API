package com.minesweeper.minesweeper.business;

import com.minesweeper.minesweeper.domain.SelectedCell;

public interface CellBusiness {
    SelectedCell revealCell(Integer cellRow, Integer cellColumn, Integer gameId);
    SelectedCell flagCell(Integer cellRow, Integer cellColumn, Integer gameId);
}
