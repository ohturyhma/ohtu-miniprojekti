/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for the database
 * @author johyry
 */
public class Database {
    
    private String databaseAddress;

    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
    
    /**
     * Initializes db by creating tables if nonexistent.
     * 
     */

    public void init() {
        List<String> tables = createTables();

        
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            
            for (String table : tables) {

                st.executeUpdate(table);
            }

        } catch (Throwable t) {
 
        }
    }
    
    /**
     * Createtables for initializing.
     * @return return the commands for creating the datatables
     */
    private List<String> createTables() {
        ArrayList<String> list = new ArrayList<>();

        // create tables
        list.add("CREATE TABLE IF NOT EXISTS "
                + "books(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " author varchar, title varchar, isbn varchar, type varchar)");
        list.add("CREATE TABLE IF NOT EXISTS "
                + "videos(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " url varchar, title varchar, comment varchar, type varchar)");
        list.add("CREATE TABLE IF NOT EXISTS "
                + "podcasts(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " author varchar, title varchar, description varchar, type varchar)");
        list.add("CREATE TABLE IF NOT EXISTS "
                + "blogposts(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " author varchar, title varchar, url varchar, type varchar)");
        
        
        
        
        

        return list;
    }
    
}
