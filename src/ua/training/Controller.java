/*
 * Controller
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

import java.util.Scanner;

public class Controller {

    private int      index;
    private Model    model;
    private View     view;
    private KeyValue hashMap;

    /**
     * Constructor, initializes a new object.
     * @param model
     * @param view
     * @param hashMap
     */
    public Controller(Model model, View view, KeyValue hashMap) {
        this.model = model;

        //just for practice; clone, equals & hashCode can be removed;
        View temp = view.clone();
        if (view.hashCode() == temp.hashCode()) {
            if (view.toString().equals(temp.toString()))
                    this.view = temp;
        }
        else
            this.view = view;
        this.hashMap = hashMap;
    }

    /**
     * Constructor, initializes a new object.
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Work method.
     */
    public void processUser() {

        Scanner sc = new Scanner(System.in);

        hashMap.setHashMap();
        view.printMessage(View.GAME_ON);
        while (model.getUserGrid().indexOf(".") != -1) {
            putCrossOnGrid(sc);
            if (model.checkResults(index, 'X')) {
                view.printMessage(model.getDisplayGrid().toString());
                view.printMessage(View.SUCCESS);
                return;
            }
            if (model.getBotGrid().indexOf(".") != -1) {
                putNaughtOnGrid();
                if (model.checkResults(index, 'O')) {
                    view.printMessage(model.getDisplayGrid().toString());
                    view.printMessage(View.FAIL);
                    return;
                }
            }
        }
        view.printMessage(View.DRAW);
    }

    /**
     * Handles user input coordinate of X.
     * Transforms coordinate to index.
     * Places X on the grid by gotten index.
     * @param sc
     */
    private void putCrossOnGrid(Scanner sc) {

        String coordinate;

        do {
            view.printMessage(View.PUT_X);
            view.printMessage(model.getDisplayGrid().toString());
            coordinate = sc.nextLine();
            while ( ! hashMap.isValidCoordinate(coordinate)) {
                view.printMessage(View.ERROR + View.PUT_X);
                coordinate = sc.nextLine();
            }
            index = hashMap.getIndexOfCoordinate(coordinate);
            if (model.getUserGrid().charAt(index) != '.') {
                view.printMessage(View.OUT_OF_REACH);
            }
        } while (model.getUserGrid().charAt(index) != '.');
        model.setUserGrid(index, Character.forDigit(index, 10));
        model.setBotGrid(index, 'X');
        model.setDisplayGrid(transformIndexForDisplayGrid(), 'X');
    }

    /**
     * Transforms index of a symbol (X or O)
     * for placing it on Display grid.
     * @return index for Display grid
     */
    private int transformIndexForDisplayGrid() {

        int x;
        int indexOfDisplayGrid;

        if (index == 0 || index == 1 || index == 2) {
            x = 10;
        }
        else if (index == 3 || index == 4 || index == 5) {
            x = 15;
        }
        else {
            x = 20;
        }
        indexOfDisplayGrid = index + (index - (3 * (index / 3))) + x;
        return indexOfDisplayGrid;
    }

    /**
     * Places 'O' on the grid.
     */
    private void putNaughtOnGrid() {

        view.printMessage(View.BOT_TURN);
        choosePositionForNaught();
        model.setBotGrid(index, Character.forDigit(index, 10));
        model.setUserGrid(index, 'O');
        model.setDisplayGrid(transformIndexForDisplayGrid(), 'O');
    }

    /**
     * Finds appropriate index for placing 'O'.
     */
    private void choosePositionForNaught() {

        String botGrid = model.getBotGrid().toString();

        if (botGrid.matches("(\\..{2}X.{2}X.*)|(\\.X{2}.*)")) {
            index = 0;
        }
        else if (botGrid.matches(".\\..{2}X.{2}X.")) {
            index = 1;
        }
        else if (botGrid.matches("(.{2}\\..{2}X.{2}X)|(.{2}\\..X.X.*)|(X{2}\\..*)")) {
            index = 2;
        }
        else if (botGrid.matches("(.{3}\\.X{2}.*)|(X.{2}\\..{2}X.*)")) {
            index = 3;
        }
        else if (botGrid.charAt(4) == '.') {
            index = 4;
        }
        else if (botGrid.matches("(.{3}X{2}\\..*)|(.{2}X.{2}\\..{2}X)")) {
            index = 5;
        }
        else if (botGrid.matches("(.{2}X.X.\\..*)|(X.{2}X.{2}\\..*)|(.{6}\\.X{2})")) {
            index = 6;
        }
        else if (botGrid.matches(".X.{2}X.{2}\\..")) {
            index = 7;
        }
        else if (botGrid.matches("(.{2}X.{2}X.{2}\\.)|(.{6}X{2}\\.)")) {
            index = 8;
        }
        else {
            index = botGrid.indexOf('.');
        }
    }
}
