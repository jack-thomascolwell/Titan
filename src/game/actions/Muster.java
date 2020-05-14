package game.actions;

import game.masterboard.Legion;
import game.masterboard.lands.Land;
import game.characters.Character;

public class Muster extends BoardAction{

    private Character new_troop;
    /**
     * land is the land the legion is on.
     * legion is the legion being mustered.
     * @param legion
     */
    public Muster(Legion legion, Character troop) {
        //land = legion.getLand();
        this.legion = legion;
        new_troop = troop;
    }

    @Override
    /**
     * prompts legion to add a new troop, returns if it succeeds
     * @return troop_added
     */
    public boolean preformAction() {
        return legion.add(new_troop);
    }
}
