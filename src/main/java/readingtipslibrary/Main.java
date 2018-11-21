/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import java.util.Scanner;

/**
 *
 * @author strajama
 */
public class Main {
    
        public static void main(String[] args) throws Exception {  
        App application = new App();
        application.init(new ConsoleIO());
        application.run();
    }
}
