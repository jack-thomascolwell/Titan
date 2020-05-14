package game.actions;

import game.masterboard.Legion;
import game.masterboard.lands.Land;

public class Move extends BoardAction{

    /**
     *
     * @param end_land
     * @param legion
     */
    public Move(Land end_land, Legion legion) {
        interact_land = end_land;
        interact_legion = legion;
    }

    @Override
    /**
     * sets interact_legion land to interact_land
     * @return actionpreformed?
     */
    public boolean preformAction() {
        //interact_legion.setLand(interact_land);
        return true;
    }
}
