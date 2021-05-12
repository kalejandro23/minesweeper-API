package com.minesweeper.minesweeper.business;

import com.minesweeper.minesweeper.data.GameRepository;
import com.minesweeper.minesweeper.domain.Cell;
import com.minesweeper.minesweeper.domain.Game;
import com.minesweeper.minesweeper.domain.Level;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameBusinessImpl implements GameBusiness{

    private GameRepository repository;

    public GameBusinessImpl(GameRepository gameRepository) {
        this.repository = gameRepository;
    }


    @Override
    public Cell[][] createGame(Game game) {

        Cell [][] board = new Cell[Level.EASY.getRows()][Level.EASY.getColumns()];
        List<Cell> cellList = new ArrayList<>();
        for (int i = 0; i < Level.EASY.getRows(); i++) {
            for (int j = 0; j < Level.EASY.getColumns(); j++) {
                board[i][j] = new Cell(i,j);
                cellList.add(board[i][j]);

            }
        }
        int bombsAssigned = Level.EASY.getBombs();
        while(bombsAssigned > 0 ) {
            int row = getRandomNumber(Level.EASY);
            int column = getRandomNumber(Level.EASY);
            if (board[row][column] == null || !board[row][column].isBomb()) {
                if(board[row][column] == null) { board[row][column] = new Cell(); }
                board[row][column].setBomb(true);
                bombsAssigned--;
            }
        }
        game.setCellList(cellList);
        repository.save(game);
        return board;
    }

    public int getRandomNumber(Level level){
        Random t = new Random();
        int num;
        {
            num=t.nextInt(level.getColumns());
        } while(num > level.getColumns());

        return num;
    }
}
