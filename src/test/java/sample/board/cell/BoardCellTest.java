package sample.board.cell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardCellTest {

    @Test
    public void shouldCreateCellProperly() {
        BoardCell cell = new BoardCell(10, 2);
        int x = cell.getX();
        int y = cell.getY();

        assertEquals(x, 10);
        assertEquals(y, 2);
    }
}