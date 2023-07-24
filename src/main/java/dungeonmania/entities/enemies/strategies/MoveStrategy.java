package dungeonmania.entities.enemies.strategies;

import dungeonmania.Game;
import dungeonmania.entities.Entity;
import dungeonmania.util.Position;

public interface MoveStrategy {
    Position getNextPosition(Entity entity, Game game);
}
