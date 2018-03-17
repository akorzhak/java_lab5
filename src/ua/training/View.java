/*
 * View
 *
 * Description: This source file is a part of
 * Tic-Tac-Toe Game.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/03/16
 *
 * Updated: 2018/03/17
 */
package ua.training;

import java.util.ArrayList;

public class View implements Cloneable{

    public static final String GAME_ON = "TIC-TAC-TOE GAME ON!\nYou play for X's!\n" 
            + "Your task: place three of X's in horizontal, vertical, or diagonal row.\n";
    public static final String PUT_X = "Put the X on the grid!\nInput coordinates.\nE.G = 1A\n";
    public static final String ERROR = "ERROR: invalid coordinates! Try again.\n";
    public static final String OUT_OF_REACH = "The coordinate is OUT OF REACH!\n"
            + "Please, choose FREE one.\n";
    public static final String BOT_TURN = "Bot is playing...\n";
    public static final String SUCCESS = "SUCCESS! Congrats!\n";
    public static final String FAIL = "FAIL! Don't worry! Be happy!\n";
    public static final String DRAW = "DRAW!";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public View clone() {
        try {
            return (View)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("impossible!");
        }
    }

    /**
     * Overrides equals method.
     * @param obj
     * @return true - if objects are equal, otherwise - false
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj instanceof View){
            View temp = (View) obj;
            return GAME_ON.equals(temp.GAME_ON) && PUT_X.equals(temp.PUT_X)
                    && ERROR.equals(temp.ERROR);
        } else
            return false;
    }

    public int hashCode() {
        return (SUCCESS.length());
    }

    public String toString() {
        return getClass().getName();
    }
}
