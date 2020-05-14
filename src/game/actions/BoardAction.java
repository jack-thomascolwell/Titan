package game.actions;

import game.masterboard.Legion;
import game.masterboard.lands.Land;

/**
 * Board Action is any action that interacts with the Main Gameboard
 * i.e. move, muster
 */
public abstract class BoardAction implements Action {

    /**
     * Board actions always interact with 1 land and 1 legion
     * either to move legion
     * to land
     * or bolster legion
     * to land
     */
    protected Land land;
    protected Legion legion;

    /**
     * get land
     * @return land
     */
    public Land getLand()
    {return land;}

    /**
     * get legion
     * @return legion
     *
     */
    public Legion getLegion()
    {return legion;}

    /**
     * preforms intended action, returns if it was succesfull
     * @return action_preformed
     */
    public abstract boolean preformAction();
}
