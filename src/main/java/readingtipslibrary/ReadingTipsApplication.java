/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ReadingTipsApplication {

    private Connection connection;

    public void init() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:readingtips.db");
        } catch (SQLException ex) {
            Logger.getLogger(ReadingTipsApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run(String[] args) {
		if (args == null || args.length == 0)
			return;
        String action = args[0];
		int[] test;
        switch (action) {
            case "find-all":
                /* 
                List<Tip> allTypes = new ArrayList<>();
                allTypes.add(bookDao.findAll());
                allTypes.add(videoDao.findAll());
                allTypes.add(podcastDao.findAll());
                allTypes.add(blogDao.findAll());
                allTypes.stream().forEach(System.out::println);
                break;
                
                 */

                break;
            case "insert":
                String type = args[1];
                /* 
                   if(type.equals("book")) {
                                     name    author
                    bookDao.insert(args[2], args[3]);
                } else if(type.equals("video")) {
                                    title       url
                    videoDao.insert(args[2], args[3]);
                } else if(type.equals("podcast") {
                                        name   title    description
                    podcastDao.insert(args[2], args[3], args[4]);
                } else if(type.equals("blog")) {
                                    title   url
                    blogDao.insert(args[2], args[3]);
                } 
                 */
                break;
            default:
                throw new IllegalArgumentException("First argument needs to be insert or find-all");
        }
    }
}
