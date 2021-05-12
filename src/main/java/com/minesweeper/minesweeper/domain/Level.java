package com.minesweeper.minesweeper.domain;

public enum Level {

    EASY(4,4,1);

    private int columns;
    private int rows;
    private int bombs;

    private Level(int columns, int rows, int bombs) {
        this.columns = columns;
        this.rows = rows;
        this.bombs = bombs;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int getBombs() {
        return bombs;
    }
}
