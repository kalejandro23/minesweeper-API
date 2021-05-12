package com.minesweeper.minesweeper;

import com.minesweeper.minesweeper.business.GameBusiness;
import com.minesweeper.minesweeper.business.GameBusinessImpl;
import com.minesweeper.minesweeper.data.GameRepository;
import com.minesweeper.minesweeper.domain.Cell;
import com.minesweeper.minesweeper.domain.Game;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestGameBussinessImpl {

    @Test
    void TestCreateGame() {
        GameRepository gameRepository = Mockito.mock(GameRepository.class);
        GameBusiness gameBusiness = new GameBusinessImpl(gameRepository);
        Game game = new Game();
        game.setName("Test");
        game.setRows(3);
        game.setColumns(3);
        Cell[][] result = gameBusiness.createGame(game);
        Mockito.when(gameRepository.save(game)).thenReturn(game);
        assert result.length == 4;
    }
}
