package dungeonmania.goals;

import org.json.JSONArray;
import org.json.JSONObject;

public class GoalFactory {
    public static Goal createGoal(JSONObject jsonGoal, JSONObject config) {
        JSONArray subgoals;
        switch (jsonGoal.getString("goal")) {
            case "AND":
                subgoals = jsonGoal.getJSONArray("subgoals");
                return new AndGoalStrategy(createGoal(subgoals.getJSONObject(0), config),
                        createGoal(subgoals.getJSONObject(1), config));
            case "OR":
                subgoals = jsonGoal.getJSONArray("subgoals");
                return new OrGoalStrategy(createGoal(subgoals.getJSONObject(0), config),
                        createGoal(subgoals.getJSONObject(1), config));
            case "exit":
                return new ExitGoalStrategy();
            case "boulders":
                return new BouldersGoalStrategy();
            case "treasure":
                int treasureGoal = config.optInt("treasure_goal", 1);
                return new TreasureGoalStrategy(treasureGoal);
            default:
                return null;
        }
    }
}
