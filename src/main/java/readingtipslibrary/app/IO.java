/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.app;

import readingtipslibrary.dao.Database;

/**
 *
 * Interface for using application
 */
public interface IO {

    void warn(String toPrint);
    void prompt(String toPrint);
    void success(String toPrint);

    String readLine(String line);
    int readInt(String line);
    Database getDatabase();
}
