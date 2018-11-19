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
import readingtipslibrary.dao.PodcastDao;
import readingtipslibrary.dao.VideoDao;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author User
 */
public class ReadingTipsApplication {

    private Connection connection;
    private VideoDao videoDao = new VideoDao();
    private BookDao bookDao = new BookDao();
    private BlogDao blogDao = new BlogDao();
    private PodcastDao podcastDao = new PodcastDao();

    public void init() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:readingtips.db");
            createTables();

        } catch (SQLException ex) {
            Logger.getLogger(ReadingTipsApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createTables() throws SQLException {
        String createTableSql = "CREATE TABLE IF NOT EXISTS "
                + "books(id INTEGER PRIMARY KEY AUTOINCREMENT, author varchar, title varchar, isbn varchar, type varchar)";
        connection.createStatement().executeUpdate(createTableSql);

        createTableSql = "CREATE TABLE IF NOT EXISTS "
                + "videos(id INTEGER PRIMARY KEY AUTOINCREMENT, url varchar, title varchar, comment varchar, type varchar)";

        connection.createStatement().executeUpdate(createTableSql);

        createTableSql = "CREATE TABLE IF NOT EXISTS "
                + "podcasts(id INTEGER PRIMARY KEY AUTOINCREMENT, author varchar, title varchar, description varchar, type varchar)";
        connection.createStatement().executeUpdate(createTableSql);

        createTableSql = "CREATE TABLE IF NOT EXISTS "
                + "blogposts(id INTEGER PRIMARY KEY AUTOINCREMENT, author varchar, title varchar, url varchar, type varchar)";
        connection.createStatement().executeUpdate(createTableSql);
    }

    public void run() {

        Scanner input = new Scanner(System.in);
        String command = "";
        while (!command.equals("quit")) {
            System.out.println("Commands: insert, find-all, quit");
            System.out.print("Enter command: ");
            command = input.nextLine();

            switch (command) {
                case "find-all":
                    // method findAll has no implementation yet in any dao
                    List<Tip> allTypes = new ArrayList<>();
                    allTypes.addAll(bookDao.findAll());
                    allTypes.addAll(videoDao.findAll());
                    allTypes.addAll(podcastDao.findAll());
                    allTypes.addAll(blogDao.findAll());
                    allTypes.stream().forEach(System.out::println);
                    break;

                case "insert":
                    System.out.print("What do you want to insert? (book, blog, podcast, video): ");
                    String type = input.nextLine();

                    if (type.equals("book")) {

                    } else if (type.equals("video")) {

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
