package com.minesweeper.minesweeper.business;

import com.minesweeper.minesweeper.data.CellRepository;
import com.minesweeper.minesweeper.data.GameRepository;
import com.minesweeper.minesweeper.domain.Cell;
import com.minesweeper.minesweeper.domain.Game;
import com.minesweeper.minesweeper.domain.SelectedCell;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CellBusinessImpl implements CellBusiness {
    CellRepository repository;
    GameRepository gameRepository;

    public CellBusinessImpl(CellRepository repository, GameRepository gameRepository) {
        this.repository = repository;
        this.gameRepository = gameRepository;
    }

    public SelectedCell revealCell(Integer cellRow, Integer cellColumn, Integer gameId) {
        Cell cell = repository.findAllByXAndYAndGameId(cellRow, cellColumn, gameId);
        if (cell!= null && cell.isBomb()) {
            //TODO GAMEOVER
        } else {
            Game game = gameRepository.getOne(gameId);
            List<Cell> selectedCells = new ArrayList<>();
            int bombs=0;
            for (int row = cellRow-1; row <=(cellRow+1); row++) {
                for (int column = cellColumn-1; column <=(cellColumn+1); column++) {
                    Cell currentCell = repository.findAllByXAndYAndGameId(row, column, gameId);
                    if (isValid(row, column, game)) {
                        if ( currentCell != null && currentCell.isBomb()) {
                            bombs++;
                        } else {
                            selectedCells.add(new Cell(row, column));
                        }
                    }
                }
            }
            return new SelectedCell(bombs, bombs == 0 ? selectedCells : null);
        }
        return null;
    }

    @Override
    public SelectedCell flagCell(Integer cellRow, Integer cellColumn, Integer gameId) {
        return null;
    }

    boolean isValid(int i,int j, Game game){
        return((i>=0 && i< game.getRows())&&(j>=0 && j< game.getColumns()));
    }
}
