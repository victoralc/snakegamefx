package sample.board.pane;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.board.cell.BoardCell;

public class PaneCell extends StackPane {

    private Rectangle background;

    public PaneCell(BoardCell cell) {
        setTranslateX(cell.getY() * cell.getHeight());
        setTranslateY(cell.getX() * cell.getWidth());

        this.background = new Rectangle(cell.getHeight(), cell.getWidth(), Color.BLACK);
        this.background.setStroke(Color.WHITE);
        getChildren().add(background);
    }
}
