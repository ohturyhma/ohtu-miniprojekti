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

    public ConsoleIO() throws ClassNotFoundException {
        this.input = new Scanner(System.in);
        this.database = new Database("jdbc:sqlite:readingtips.db");
        database.init();
    }
    

    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
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
    
    
    
}
