/*
 * Main
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

public class Main {
    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        KeyValue hashMap = new KeyValue();
        Controller controller = new Controller(model, view, hashMap);
        //Run
        controller.processUser();
    }
}
