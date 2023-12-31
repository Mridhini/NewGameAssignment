package dungeonmania.goals;

import org.json.JSONObject;

import dungeonmania.Game;
import dungeonmania.entities.Switch;

public class BouldersGoalStrategy implements Goal {
    @Override
    public boolean achieved(Game game) {
        if (game.getPlayer() == null)
            return false;

        return game.getMap().getEntities(Switch.class).stream().allMatch(s -> s.isActivated());
    }

    @Override
    public String toString(Game game) {
        if (this.achieved(game))
            return "";
        return ":boulders";
    }

    @Override
    public JSONObject getJSON() {
        JSONObject j = new JSONObject();
        j.put("goal", "boulders");
        return j;
    }
}
