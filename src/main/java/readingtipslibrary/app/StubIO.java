/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.app;

import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.dao.Database;

/**
 *
 * @author strajama
 */
public class StubIO implements IO {

    private List<String> lines;
    private Database database;
    private ArrayList<String> prints;
    private int i;

    public StubIO(List<String> values) throws ClassNotFoundException {
        this.lines = values;
        this.prints = new ArrayList<>();
        this.database = new Database("jdbc:sqlite:test.db");
        database.init();
    }

    @Override
    public void print(String toPrint) {
        prints.add(toPrint);
    }

    @Override
    public String readLine(String prompt) {
        print(prompt);
        if (i < lines.size()) {
            return lines.get(i++);
        }
        return "";
    }

    @Override
    public Database getDatabase() {
        return database;
    }

    public ArrayList<String> getPrints() {
        return prints;
    }
}
