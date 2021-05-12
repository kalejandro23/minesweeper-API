CREATE TABLE game (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  total_rows INT NOT NULL,
  total_columns INT NOT NULL
);

CREATE TABLE cell (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  x INT NOT NULL,
  y INT NOT NULL,
  is_a_bomb BIT NOT NULL,
  flagged BIT,
  game_id INT NOT NULL,
  adjBombs INT NOT NULL
);

ALTER TABLE cell
    ADD FOREIGN KEY (game_id)
    REFERENCES game(id);

CREATE TABLE associate_cell (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  x INT NOT NULL,
  y INT NOT NULL,
  parent_cell_id INT
);

ALTER TABLE associate_cell
    ADD FOREIGN KEY (parent_cell_id)
    REFERENCES cell(id);