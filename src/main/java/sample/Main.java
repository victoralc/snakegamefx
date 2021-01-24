package sample;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.pathfinding.CellState;
import com.almasb.fxgl.pathfinding.astar.AStarCell;
import com.almasb.fxgl.pathfinding.astar.AStarGrid;
import javafx.scene.input.KeyCode;
import sample.board.SnakeFactory;
import sample.board.components.Snake;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class Main extends GameApplication {

    private Entity head;
    private Entity body;
    private Entity tail;

    private Snake headComponent;
    private Snake bodyComponent;
    private Snake tailComponent;

    private AStarGrid grid;

    public AStarGrid getGrid() {
        return grid;
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("Snake Game App");
        settings.setVersion("0.1");
        settings.setWidth(600);
        settings.setHeight(600);
        settings.setSceneFactory(new SceneFactory());
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new SnakeFactory());
        spawn("BG");
        this.grid = AStarGrid.fromWorld(getGameWorld(), 15, 15,
                30, 30, type -> CellState.WALKABLE);

        head = spawn("Snake", new SpawnData(80, 0));
        headComponent = head.getComponent(Snake.class);

        body = spawn("Snake", new SpawnData(40, 0));
        bodyComponent = body.getComponent(Snake.class);

        tail = spawn("Snake", new SpawnData(0, 0));
        tailComponent = tail.getComponent(Snake.class);
    }

    @Override
    protected void initInput() {
        getInput().addAction(new UserAction("Move Up") {
            @Override
            protected void onActionBegin() {
                headComponent.moveUp();
            }
        }, KeyCode.UP);

        getInput().addAction(new UserAction("Move Left") {
            @Override
            protected void onActionBegin() {
                headComponent.moveLeft();
            }
        }, KeyCode.LEFT);

        getInput().addAction(new UserAction("Move Down") {
            @Override
            protected void onActionBegin() {

                int cellX = headComponent.getCell().getCellX();
                int cellY = headComponent.getCell().getCellY();

                AStarGrid grid = headComponent.getMovement().getGrid();
                AStarCell aStarCell = grid.get(cellX, cellY);

                headComponent.moveDown();

                int bodyX = bodyComponent.getCell().getCellX();
                int bodyY = bodyComponent.getCell().getCellY();
                AStarCell previousCellBody = grid.get(bodyX, bodyY);

                bodyComponent.getMovement().moveToCell(aStarCell);
                tailComponent.getMovement().moveToCell(previousCellBody);
            }
        }, KeyCode.DOWN);

        getInput().addAction(new UserAction("Move Right") {
            @Override
            protected void onActionBegin() {
                headComponent.moveRight();
            }
        }, KeyCode.RIGHT);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
