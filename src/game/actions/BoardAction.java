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
     * either to move interact_legion to interact_land
     * or bolster interact_legion to interact_land
     */
    protected Land interact_land;
    protected Legion interact_legion;

    /**
     * get land
     * @return interact_land
     */
    public Land getInteract_land()
    {return interact_land;}

    /**
     * get legion
     * @return interact_legion
     */
    public Legion getInteract_legion()
    {return interact_legion;}

    /**
     * preforms intended action, returns if it was succesfull
     * @return action_preformed
     */
    public abstract boolean preformAction();
}
