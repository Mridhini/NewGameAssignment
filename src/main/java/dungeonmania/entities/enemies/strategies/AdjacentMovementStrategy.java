package dungeonmania.entities.enemies.strategies;

import dungeonmania.Game;
import dungeonmania.entities.Entity;
import dungeonmania.util.Direction;
import dungeonmania.util.Position;

public class AdjacentMovementStrategy implements MoveStrategy {
    @Override
    public Position getNextPosition(Entity entity, Game game) {
        Position plrDiff = Position.calculatePositionBetween(game.getMap().getPlayer().getPosition(),
                entity.getPosition());

        Position moveX = (plrDiff.getX() >= 0) ? Position.translateBy(entity.getPosition(), Direction.RIGHT)
                : Position.translateBy(entity.getPosition(), Direction.LEFT);
        Position moveY = (plrDiff.getY() >= 0) ? Position.translateBy(entity.getPosition(), Direction.UP)
                : Position.translateBy(entity.getPosition(), Direction.DOWN);
        Position offset = entity.getPosition();
        if (plrDiff.getY() == 0 && game.getMap().canMoveTo(entity, moveX))
            offset = moveX;
        else if (plrDiff.getX() == 0 && game.getMap().canMoveTo(entity, moveY))
            offset = moveY;
        else if (Math.abs(plrDiff.getX()) >= Math.abs(plrDiff.getY())) {
            if (game.getMap().canMoveTo(entity, moveX))
                offset = moveX;
            else if (game.getMap().canMoveTo(entity, moveY))
                offset = moveY;
            else
                offset = entity.getPosition();
        } else {
            if (game.getMap().canMoveTo(entity, moveY))
                offset = moveY;
            else if (game.getMap().canMoveTo(entity, moveX))
                offset = moveX;
            else
                offset = entity.getPosition();
        }
        return offset;

    }

}
