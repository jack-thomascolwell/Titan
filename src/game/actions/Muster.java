package game.actions;

import game.masterboard.Legion;
import game.masterboard.lands.Land;

public class Muster extends BoardAction{

    /**
     * land is the land the legion is on.
     * legion is the legion being mustered.
     * @param legion
     */
    public Muster(Legion legion) {
        //land = legion.getLand();
        this.legion = legion;
    }

    @Override
    public boolean preformAction() {
        return false;
    }
}
