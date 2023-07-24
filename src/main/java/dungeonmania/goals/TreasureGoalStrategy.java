package dungeonmania.goals;

import org.json.JSONObject;

import dungeonmania.Game;

public class TreasureGoalStrategy implements Goal {
    private int target;

    public TreasureGoalStrategy(int target) {
        this.target = target;
    }

    public boolean achieved(Game game) {
        if (game.getPlayer() == null)
            return false;

        return game.getCollectedTreasureCount() >= target;
    }

    public String toString(Game game) {
        if (this.achieved(game))
            return "";

        return ":treasure";
    }

    @Override
    public JSONObject getJSON() {
        JSONObject j = new JSONObject();
        j.put("goal", "treasure");
        return j;
    }
}
