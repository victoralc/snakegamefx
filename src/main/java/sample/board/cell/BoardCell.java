package sample.board.cell;

import com.almasb.fxgl.pathfinding.Cell;

public class BoardCell extends Cell {

    private int height;
    private int width;

    public BoardCell(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public BoardCell(int height, int width,
                     int positionX, int positionY) {
        super(positionX, positionY);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
