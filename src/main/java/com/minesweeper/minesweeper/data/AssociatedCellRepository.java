package com.minesweeper.minesweeper.data;

import com.minesweeper.minesweeper.domain.AssociatedCell;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface AssociatedCellRepository extends CrudRepository<AssociatedCell, Integer> {
}
