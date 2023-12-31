package dungeonmania.goals;

import org.json.JSONArray;
import org.json.JSONObject;

import dungeonmania.Game;

public class OrGoalStrategy implements Goal {
    private Goal goal1;
    private Goal goal2;

    public OrGoalStrategy(Goal goal1, Goal goal2) {
        this.goal1 = goal1;
        this.goal2 = goal2;
    }

    @Override
    public boolean achieved(Game game) {
        if (game.getPlayer() == null)
            return false;

        return goal1.achieved(game) || goal2.achieved(game);
    }

    @Override
    public String toString(Game game) {
        if (achieved(game))
            return "";
        else
            return "(" + goal1.toString(game) + " OR " + goal2.toString(game) + ")";
    }

    @Override
    public JSONObject getJSON() {
        JSONArray subgoalsJ = new JSONArray();
        subgoalsJ.put(this.goal1.getJSON());
        subgoalsJ.put(this.goal2.getJSON());

        JSONObject j = new JSONObject();
        j.put("goal", "OR");
        j.put("subgoals", subgoalsJ);
        return j;
    }
}
