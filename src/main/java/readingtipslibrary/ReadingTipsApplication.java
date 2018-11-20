/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import readingtipslibrary.dao.BlogDao;
import readingtipslibrary.dao.BookDao;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.PodcastDao;
import readingtipslibrary.dao.VideoDao;
import readingtipslibrary.domain.Tip;
import readingtipslibrary.domain.Video;
import readingtipslibrary.domain.VideoService;

/**
 *
 * @author User
 */
public class ReadingTipsApplication {

    private Scanner input;
    private VideoService videoService;
    private Database database;

    public void init(Scanner scanner) throws ClassNotFoundException {
        this.input = scanner;
        Database database = new Database("jdbc:sqlite:readingtips.db");
        database.init();
        videoService = new VideoService(database);
    }

    public void run() throws Exception {

        
        // TÄÄ ON VAAN TESTI TOIMIIKO CONNECTION. VARSINAINEN CONNECTION TAPAHTUU DATABASE LUOKASSA
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:readingtips.db");

        } catch (SQLException ex) {
            Logger.getLogger(ReadingTipsApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        while (true) {
            
            
            
            System.out.println("Commands: insert, find-all, quit");
            System.out.print("Enter command: ");
           
            String command = input.nextLine();

            switch (command) {
                case "find-all":
                    // method findAll has no implementation yet in any dao
                    List<Tip> allTypes = new ArrayList<>();
//                    allTypes.addAll(bookDao.findAll());
                    allTypes.addAll(videoService.findAll());
//                    allTypes.addAll(podcastDao.findAll());
//                    allTypes.addAll(blogDao.findAll());
                    allTypes.stream().forEach(System.out::println);
                    break;

                case "insert":
                    System.out.print("What do you want to insert? (book, blog, podcast, video): ");
                    String type = input.nextLine();

                    if (type.equals("book")) {

                    } else if (type.equals("video")) {
                        System.out.println("Title: ?");
                        String title = input.nextLine();
                        System.out.println("url: ?");
                        String url = input.nextLine();
                        System.out.println("type: ?");
                        String tyyppi = input.nextLine();

                        if (videoService.insertVideo(title, url, tyyppi)) {
                            System.out.println("Inserting a video succeeded.");
                        } else {
                            System.out.println("Inserting a video not successfull");
                        }

                    } else if (type.equals("podcast")) {

                    } else if (type.equals("blog")) {

                    }

                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Enter a proper command (insert, find-all, quit)");
            }
        }
    }
}
