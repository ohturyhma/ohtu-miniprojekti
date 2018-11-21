/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.dao.BlogService;
import readingtipslibrary.dao.BookService;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.PodcastService;
import readingtipslibrary.dao.VideoService;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author strajama
 */
public class App {

    private IO io;
    private VideoService videoService;
    private BookService bookService;
    private PodcastService podcastService;
    private BlogService blogService;

    public void init(IO io) {
        this.io = io;
        this.blogService = new BlogService(io.getDatabase());
        this.bookService = new BookService(io.getDatabase());
        this.podcastService = new PodcastService(io.getDatabase());
        this.videoService = new VideoService(io.getDatabase());
    }

    public String ask(String ask) {
        String answer = io.readLine(ask);
        return answer;
    }

    public void run() throws Exception {

        boolean quit = false;

        while (!quit) {

            io.print("Commands: insert, find-all, quit");
            String command = io.readLine("Enter command: ");

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
                    String type = io.readLine("What do you want to insert? (book, blog, podcast, video): ");

                    if (type.equals("book")) {

                        String author = io.readLine("Author: ?");
                        String title = io.readLine("Title: ?");
                        String isbn = io.readLine("isbn: ?");

                        if (bookService.insertBook(author, title, isbn, "book")) {
                            io.print("Inserting a book succeeded.");
                        } else {
                            io.print("Inserting a book not successfull");
                        }

                    } else if (type.equals("video")) {

                        String title = io.readLine("Title: ?");
                        String url = io.readLine("url: ?");

                        if (videoService.insertVideo(title, url, "video")) {
                            io.print("Inserting a video succeeded.");
                        } else {
                            io.print("Inserting a video not successfull");
                        }

                    } else if (type.equals("podcast")) {

                        String name = io.readLine("Podcasts name: ?");
                        String title = io.readLine("Title: ?");
                        String description = io.readLine("description: ?");

                        if (podcastService.insertPodcast(name, title, description, "podcast")) {
                            io.print("Inserting a podcast succeeded.");
                        } else {
                            io.print("Inserting a podcast not successfull");
                        }

                    } else if (type.equals("blog")) {

                        String author = io.readLine("Author: ?");
                        String title = io.readLine("Title: ?");
                        String url = io.readLine("url: ?");

                        if (blogService.insertBlog(author, title, url, "blogpost")) {
                            io.print("Inserting a blog succeeded.");
                        } else {
                            io.print("Inserting a blog not successfull");
                        }
                    }

                    break;
                case "quit":
                    quit = true;
                    break;
                default:
                    io.print("Enter a proper command (insert, find-all, quit)");
            }

        }
    }


}
