/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.app;

import java.util.Scanner;
import readingtipslibrary.dao.Database;

/**
 *
 * Class is for using application. It's link between Service-classes and App
 */
public class ConsoleIO implements IO {

    private Scanner input;
    private Database database;
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public ConsoleIO() throws ClassNotFoundException {
        this.input = new Scanner(System.in);
        this.database = new Database("jdbc:sqlite:readingtips.db");
        database.init();
    }

    @Override
    public void prompt(String toPrint) {
        System.out.println(YELLOW + toPrint + RESET);
    }

    @Override
    public void warn(String toPrint) {
        System.out.println(RED + toPrint + RESET);
    }

    @Override
    public void success(String toPrint) {
        System.out.println(GREEN + toPrint + RESET);
    }

    @Override
    public String readLine(String line) {
        System.out.println(line);
        return input.nextLine();
    }

    @Override
    public Database getDatabase() {
        return database;
    }

    /**
     *
     * @param line
     * @return given line as a id-number or 0
     */
    @Override
    public int readInt(String line) {
        System.out.println(line);
        String test = input.nextLine();
        if (test.matches("^[1-9][0-9]*$")) {
            return Integer.parseInt(test);
        }
        return 0;
    }

}
