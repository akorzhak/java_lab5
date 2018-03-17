/*
 * Model
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

public class Model {

    private StringBuilder displayGrid = new StringBuilder("  A B C\n1 . . .\n2 . . .\n3 . . .\n");
    private StringBuilder userGrid = new StringBuilder(".........");
    private StringBuilder botGrid = new StringBuilder(".........");

    public void setDisplayGrid(int index, char ch) {
       displayGrid.setCharAt(index, ch);
    }

    public StringBuilder getDisplayGrid() {
        return displayGrid;
    }

    public void setUserGrid(int index, char ch) {
        userGrid.setCharAt(index, ch);
    }

    public StringBuilder getUserGrid() {
    	return userGrid;
    }

    public void setBotGrid(int index,  char ch) {
        botGrid.setCharAt(index, ch);
    }

    public StringBuilder getBotGrid() {
    	return botGrid;
    }

    /**
     * Checks whether player or bot has won the game;
     * @param index
     * @param player
     * @return true - in case of player's or bot's victory, otherwise - false.
     */
    public boolean checkResults(int index, char player) {

        String grid;
        if (player == 'X')
            grid = userGrid.toString();
        else
            grid = botGrid.toString();
        
        if (index == 0) {
           return (grid.matches("(012.*)|(0.*3.*6.*)|(0.*4.*8)"));
        } 
        else if (index == 1) {
            return (grid.matches("(012.*)|(.1.*4.*7.)"));
        }
        else if (index == 2) {
            return (grid.matches("(012.*)|(.*2.*5.*8)|(.*2.4.6.*)"));
        }
        else if (index == 3) {
            return (grid.matches("(0.*3.*6.*)|(.*345.*)"));
        }
        else if (index == 4) {
            return (grid.matches("(.*345.*)|(0.*4.*8)|(.*2.4.6.*)|(.1.*4.*7.)"));
        }
        else if (index == 5) {
            return (grid.matches("(.*345.*)|(.*2.*5.*8)"));
        }
        else if (index == 6) {
            return (grid.matches("(0.*3.*6.*)|(.*2.4.6.*)|(.*678)"));
        }
        else if (index == 7) {
            return (grid.matches("(.1.*4.*7.)|(.*678)"));
        }
        else {
            return (grid.matches("(0.*4.*8)|(.*2.*5.*8)|(.*678)"));
        }
    }
}
