package com.minesweeper.minesweeper.domain;

import com.sun.istack.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "associatedCell")
public class AssociatedCell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "x")
    private int x;

    @NotNull
    @Column(name = "y")
    private int y;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_cell_id")
    Cell game;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Cell getGame() {
        return game;
    }

    public void setGame(Cell game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AssociatedCell that = (AssociatedCell) o;

        return new EqualsBuilder().append(x, that.x).append(y, that.y).append(game, that.game).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(x).append(y).append(game).toHashCode();
    }
}
