/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.app;

import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.dao.DaoService;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author strajama
 */
public class App {

    private IO io;
    private DaoService daoService;

    public void init(IO io) {
        this.io = io;
        this.daoService = new DaoService(io.getDatabase());
    }

    public String ask(String ask) {
        String answer = io.readLine(ask);
        return answer;
    }

    public void run() throws Exception {

        boolean quit = false;

        while (!quit) {

            io.print("Commands: insert, find-type, find-all, delete, quit");
            String command = io.readLine("Enter command: ");

            switch (command) {
                case "find-type":
                    String typeToFind = io.readLine("type: ?");
                    List<Tip> allFromType = findByType(typeToFind);
                    for (Tip tip : allFromType) {
                        io.print(tip.toString());
                    }
                    
                break;
                case "find-all":
                    // method findAll has no implementation yet in any dao
                    List<Tip> allTypes = new ArrayList<>();
                    allTypes.addAll(daoService.findAllBooks());
                    allTypes.addAll(daoService.findAllVideos());
                    allTypes.addAll(daoService.findAllPodcasts());
                    allTypes.addAll(daoService.findAllBlogs());
                    for (Tip x : allTypes) {
                        io.print(x.toString());
                    }
//                    allTypes.stream().forEach(System.out::println);
                    break;

                case "insert":
                    String type = io.readLine("What do you want to insert? (book, blog, podcast, video): ");

                    if (type.equals("book")) {

                        String author = io.readLine("Author: ?");
                        String title = io.readLine("Title: ?");
                        String isbn = io.readLine("isbn: ?");
                        String description = io.readLine("description: ?");
                        if (daoService.insertBook(author, title, isbn, "book", description)) {
                            io.print("Inserting a book succeeded.");
                        } else {
                            io.print("Inserting a book not successfull.");
                        }

                    } else if (type.equals("video")) {

                        String title = io.readLine("Title: ?");
                        String url = io.readLine("url: ?");
                        String description = io.readLine("description: ?");
                        if (daoService.insertVideo(title, url, "video", description)) {
                            io.print("Inserting a video succeeded.");
                        } else {
                            io.print("Inserting a video not successfull.");
                        }

                    } else if (type.equals("podcast")) {

                        String name = io.readLine("Podcasts name: ?");
                        String title = io.readLine("Title: ?");
                        String description = io.readLine("description: ?");

                        if (daoService.insertPodcast(name, title, description, "podcast")) {
                            io.print("Inserting a podcast succeeded.");
                        } else {
                            io.print("Inserting a podcast not successfull.");
                        }

                    } else if (type.equals("blog")) {

                        String author = io.readLine("Author: ?");
                        String title = io.readLine("Title: ?");
                        String url = io.readLine("url: ?");
                        String description = io.readLine("description: ?");
                        if (daoService.insertBlog(author, title, url, "blogpost", description)) {
                            io.print("Inserting a blog succeeded.");
                        } else {
                            io.print("Inserting a blog not successfull.");
                        }
                    }

                    break;
                case "delete":
                    type = io.readLine("What do you want to delete? Command deletes all of them. (books, blogs, podcasts, videos): ");
                    
                    if (type.equals("books")) {

                       
                        if (daoService.destroyAllBooks()) {
                            io.print("Deleting all books succeeded.");
                        } else {
                            io.print("Deleting all books not successfull.");
                        }

                    } else if (type.equals("videos")) {

                        

                        if (daoService.destroyAllVideos()) {
                            io.print("Deleting all videos succeeded.");
                        } else {
                            io.print("Deleting all videos not successfull.");
                        }

                    } else if (type.equals("podcasts")) {

                        if (daoService.destroyAllPodcasts()) {
                            io.print("Deleting all podcasts succeeded.");
                        } else {
                            io.print("Deleting all podcasts not successfull.");
                        }

                    } else if (type.equals("blogs")) {

                        if (daoService.destroyAllBlogs()) {
                            io.print("Deleting all blogs succeeded.");
                        } else {
                            io.print("Deleting all blogs not successfull.");
                        }
                    }
                case "quit":
                    quit = true;
                    break;
                default:
                    io.print("Enter a proper command (insert, find-type, find-all, delete, quit)");
            }

        }
    }

    private List<Tip> findByType(String typeToFind) {
        List<Tip> tips = new ArrayList<>();
        switch(typeToFind) {
            case "book":
                tips = daoService.findAllBooks();
            break;
            case "blog":
                tips = daoService.findAllBlogs();
            break;
            case "video":
                tips = daoService.findAllVideos();
            break;
            case "podcast":
                 tips = daoService.findAllPodcasts();   
            break;
            default:
                io.print("Enter a proper type (book, podcast, video, blog)");
        }
        return tips;
    }

}
