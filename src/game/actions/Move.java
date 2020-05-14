package game.actions;

import game.masterboard.Legion;
import game.masterboard.lands.Land;

public class Move extends BoardAction{

    /**
     *
     * @param land
     * @param legion
     */
    public Move(Land land, Legion legion) {
        this.land = land;
        this.legion = legion;
    }

    @Override
    /**
     * sets legion land to land
     * @return actionpreformed?
     */
    public boolean preformAction() {
        //legion.setLand(land);
        return true;
    }
}
