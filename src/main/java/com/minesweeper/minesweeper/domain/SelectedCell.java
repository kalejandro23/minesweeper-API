package com.minesweeper.minesweeper.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class SelectedCell {
    int adjBombs;
    int row;
    int column;
    int gameId;

    List<Cell> adjCellList;

    public SelectedCell() {}

    public SelectedCell(int adjBombs, List<Cell> adjCellList) {
        this.adjBombs = adjBombs;
        this.adjCellList = adjCellList;
    }

    public int getAdjBombs() {
        return adjBombs;
    }

    public void setAdjBombs(int adjBombs) {
        this.adjBombs = adjBombs;
    }

    public List<Cell> getAdjCellList() {
        return adjCellList;
    }

    public void setAdjCellList(List<Cell> adjCellList) {
        this.adjCellList = adjCellList;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SelectedCell that = (SelectedCell) o;

        return new EqualsBuilder().append(adjBombs, that.adjBombs).append(adjCellList, that.adjCellList).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(adjBombs).append(adjCellList).toHashCode();
    }
}
