package sample.board.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.pathfinding.CellMoveComponent;
import com.almasb.fxgl.pathfinding.astar.AStarCell;
import com.almasb.fxgl.pathfinding.astar.AStarMoveComponent;

public class Snake extends Component {

    private SnakeBody body = new SnakeBody();
    private CellMoveComponent cell;
    private AStarMoveComponent movement;

    public void moveRight() {
        movement.moveToRightCell();
    }

    public void moveLeft() {
        movement.moveToLeftCell();
    }

    public void moveUp() {
        movement.moveToUpCell();
    }

    public void moveDown() {
        movement.moveToDownCell();
    }

    public SnakeBody getBody() {
        return body;
    }

    public void setBody(SnakeBody body) {
        this.body = body;
    }

    public CellMoveComponent getCell() {
        return cell;
    }

    public void setCell(CellMoveComponent cell) {
        this.cell = cell;
    }

    public AStarMoveComponent getMovement() {
        return movement;
    }

}
