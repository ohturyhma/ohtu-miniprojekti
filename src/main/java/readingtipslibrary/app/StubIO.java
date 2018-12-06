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
    public String readLine(String line) {
        print(line);
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
/**
 * 
 * @param line
 * @return given line as a id-number or 0
 */
    @Override
    public int readInt(String line) {
        print(line);
        String test = lines.get(i++);
        if (test.matches("^[1-9][0-9]*$")) {
            return Integer.parseInt(test);
        }
        return 0;
    }
}
