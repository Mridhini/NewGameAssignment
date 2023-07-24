package dungeonmania.entities.enemies;

import dungeonmania.Game;
import dungeonmania.entities.collectables.potions.InvincibilityPotion;
import dungeonmania.entities.enemies.strategies.AdjacentMovementStrategy;
import dungeonmania.entities.enemies.strategies.MoveStrategy;
import dungeonmania.entities.enemies.strategies.RandomMovementStrategy;
import dungeonmania.map.GameMap;
import dungeonmania.util.Position;

public class ZombieToast extends Enemy {
    public static final double DEFAULT_HEALTH = 5.0;
    public static final double DEFAULT_ATTACK = 6.0;

    public ZombieToast(Position position, double health, double attack) {
        super(position, health, attack);
    }

    @Override
    public void move(Game game) {
        Position nextPos;
        GameMap map = game.getMap();
        if (map.getPlayer().getEffectivePotion() instanceof InvincibilityPotion) {
            // Move adjacent using AdjacentMovementStrategy
            MoveStrategy movementStrategy = new AdjacentMovementStrategy();
            nextPos = movementStrategy.getNextPosition(this, game);
        } else {
            // Move randomly using RandomMovementStrategy
            MoveStrategy movementStrategy = new RandomMovementStrategy();
            nextPos = movementStrategy.getNextPosition(this, game);
        }
        map.moveTo(this, nextPos);
    }
}
