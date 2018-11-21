/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import readingtipslibrary.dao.Database;

/**
 *
 * Interface for using application
 */
public interface IO {

    void print(String toPrint);

    String readLine(String line);
    
    Database getDatabase();
}
