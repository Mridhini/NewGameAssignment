package dungeonmania.entities.enemies.strategies;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import dungeonmania.Game;
import dungeonmania.entities.Entity;
import dungeonmania.util.Position;

public class RandomMovementStrategy implements MoveStrategy {
    @Override
    public Position getNextPosition(Entity entity, Game game) {
        Random randGen = new Random();
        List<Position> pos = entity.getPosition().getCardinallyAdjacentPositions();
        pos = pos.stream().filter(p -> game.getMap().canMoveTo(entity, p)).collect(Collectors.toList());
        if (pos.size() == 0) {
            return entity.getPosition();
        } else {
            return pos.get(randGen.nextInt(pos.size()));
        }
    }
}
