/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import readingtipslibrary.dao.Database;
import readingtipslibrary.domain.BlogService;
import readingtipslibrary.domain.BookService;
import readingtipslibrary.domain.PodcastService;
import readingtipslibrary.domain.Tip;
import readingtipslibrary.domain.VideoService;

/**
 *
 * @author User
 */
public class ReadingTipsApplication {

    private Scanner input;
    private VideoService videoService;
    private BookService bookService;
    private PodcastService podcastService;
    private BlogService blogService;
    private Database database;

    public void init(Scanner scanner) throws ClassNotFoundException {
        this.input = scanner;
        Database database = new Database("jdbc:sqlite:readingtips.db");
        database.init();
        videoService = new VideoService(database);
        bookService = new BookService(database);
        podcastService = new PodcastService(database);
        blogService = new BlogService(database);
    }

    public void run() throws Exception {

        while (true) {

            System.out.println("Commands: insert, find-all, quit");
            System.out.print("Enter command: ");

            String command = input.nextLine();

            switch (command) {
                case "find-all":
                    // method findAll has no implementation yet in any dao
                    List<Tip> allTypes = new ArrayList<>();
                    allTypes.addAll(bookService.findAll());
                    allTypes.addAll(videoService.findAll());
                    allTypes.addAll(podcastService.findAll());
                    allTypes.addAll(blogService.findAll());
                    allTypes.stream().forEach(System.out::println);
                    break;

                case "insert":
                    System.out.print("What do you want to insert? (book, blog, podcast, video): ");
                    String type = input.nextLine();

                    if (type.equals("book")) {
                        System.out.println("Author: ?");
                        String author = input.nextLine();
                        System.out.println("Title: ?");
                        String title = input.nextLine();
                        System.out.println("isbn: ?");
                        String isbn = input.nextLine();
                        System.out.println("type: ?");
                        String tyyppi = input.nextLine();

                        if (bookService.insertBook(author, title, isbn, tyyppi)) {
                            System.out.println("Inserting a book succeeded.");
                        } else {
                            System.out.println("Inserting a book not successfull");
                        }

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
                        System.out.println("Author: ?");
                        String author = input.nextLine();
                        System.out.println("Title: ?");
                        String title = input.nextLine();
                        System.out.println("description: ?");
                        String description = input.nextLine();
                        System.out.println("type: ?");
                        String tyyppi = input.nextLine();

                        if (podcastService.insertPodcast(author, title, description, tyyppi)) {
                            System.out.println("Inserting a podcast succeeded.");
                        } else {
                            System.out.println("Inserting a podcast not successfull");
                        }

                    } else if (type.equals("blog")) {
                        System.out.println("Author: ?");
                        String author = input.nextLine();
                        System.out.println("Title: ?");
                        String title = input.nextLine();
                        System.out.println("url: ?");
                        String url = input.nextLine();
                        System.out.println("type: ?");
                        String tyyppi = input.nextLine();

                        if (blogService.insertBlog(author, title, url, tyyppi)) {
                            System.out.println("Inserting a blog succeeded.");
                        } else {
                            System.out.println("Inserting a blog not successfull");
                        }
                    }

                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Enter a proper command (insert, find-all, quit)");
            }
            break;
        }
    }
}
