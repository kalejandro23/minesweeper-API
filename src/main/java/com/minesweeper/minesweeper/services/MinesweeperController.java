package com.minesweeper.minesweeper.services;

import com.minesweeper.minesweeper.business.CellBusiness;
import com.minesweeper.minesweeper.business.GameBusiness;
import com.minesweeper.minesweeper.domain.Cell;
import com.minesweeper.minesweeper.domain.Game;
import com.minesweeper.minesweeper.domain.SelectedCell;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MinesweeperController {

    GameBusiness gameBusiness;
    CellBusiness cellBusiness;

    public MinesweeperController(GameBusiness gameBusiness, CellBusiness cellBusiness){
        this.gameBusiness = gameBusiness;
        this.cellBusiness = cellBusiness;
    }

    @PostMapping("/newGame")
    public Cell[][] createGame(@RequestBody Game game) {
        return gameBusiness.createGame(game);
    }

    @PostMapping("/revealCell")
    public SelectedCell revealCell(@RequestBody SelectedCell cell) {
        return cellBusiness.revealCell(cell.getRow(), cell.getColumn(), cell.getGameId());
    }

    @PostMapping("/flagCell")
    public SelectedCell flagCell(@RequestBody SelectedCell cell) {
        return cellBusiness.revealCell(cell.getRow(), cell.getColumn(), cell.getGameId());
    }
}
