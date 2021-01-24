package sample.board;

import com.almasb.fxgl.pathfinding.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.board.cell.BoardCell;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameBoardTest {

    private GameBoard gameBoard;

    @BeforeEach
    public void setUp() {
        this.gameBoard = new GameBoard();
    }

    @Test
    public void shouldCreateCellsInsideTheBoardProperly() {

    }
}