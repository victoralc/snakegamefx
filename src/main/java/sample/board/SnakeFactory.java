package sample.board;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.pathfinding.CellMoveComponent;
import com.almasb.fxgl.pathfinding.CellState;
import com.almasb.fxgl.pathfinding.astar.AStarCell;
import com.almasb.fxgl.pathfinding.astar.AStarMoveComponent;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Main;
import sample.board.components.Snake;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class SnakeFactory implements EntityFactory {

    private static final double TILE_SIZE = 40;

    @Spawns("BG")
    public Entity newBackground(SpawnData data) {
        return entityBuilder()
                .at(0, 0)
                .view(new Rectangle(600, 600, Color.WHITE))
                .zIndex(-1)
                .build();
    }

    @Spawns("Snake")
    public Entity snake(SpawnData data) {

        Rectangle rectangle = new Rectangle(40, 40, Color.BLACK);
        rectangle.setStroke(Color.WHITE);

        return entityBuilder()
                .at(data.getX(), data.getY())
                .viewWithBBox(rectangle)
                .with(new CellMoveComponent(40, 40, 250))
                .with(new CollidableComponent(true))
                .with(new AStarMoveComponent(FXGL.<Main>getAppCast().getGrid()))
                .with(new Snake())
                .build();
    }
}
