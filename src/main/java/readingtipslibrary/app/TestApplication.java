/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import readingtipslibrary.dao.DaoService;
import readingtipslibrary.dao.Database;
import readingtipslibrary.domain.Tip;

/**
 *
 * This is for automatic testing
 */
public class TestApplication {

    private List<String> input;
    private DaoService daoService;
    private Database database;
    private List<String> prints;

    public void init(List<String> tests) throws ClassNotFoundException {
        this.input = tests;
        Database database = new Database("jdbc:sqlite:test.db");
        database.init();
        prints = new ArrayList<>();
        daoService = new DaoService(database);
    }

    public void run() throws Exception {

        boolean quit = false;
        int i = 0;

        while (!quit && i < input.size()) {

            String command = input.get(i);
            i++;

            switch (command) {
                case "find-type":
                    String typeToFind = input.get(i);
                    i++;
                    List<Tip> allFromType = findByType(typeToFind);
                    
                break;
                case "find-all":
                    // method findAll has no implementation yet in any dao
                    List<Tip> allTypes = new ArrayList<>();
                    allTypes.addAll(daoService.findAllBooks());
                    allTypes.addAll(daoService.findAllPodcasts());
                    allTypes.addAll(daoService.findAllVideos());
                    allTypes.addAll(daoService.findAllBlogs());
                    //                allTypes.stream().forEach(System.out::println);
                    break;

                case "insert":
                    String type = input.get(i);
                    i++;

                    if (type.equals("book") && i + 2 < input.size()) {
//                        System.out.println("Author: ?");
                        String author = input.get(i);
                        i++;
                        //                      System.out.println("Title: ?");
                        String title = input.get(i);
                        i++;
                        //                    System.out.println("isbn: ?");
                        String isbn = input.get(i);
                        i++;
                        String description = input.get(i);
                        i++;
                        if (daoService.insertBook(author, title, isbn, "book", description)) {
                            prints.add("Inserting a book succeeded.");
                        } else {
                            prints.add("Inserting a book not successfull");
                        }

                    } else if (type.equals("video") && i + 1 < input.size()) {
//                        System.out.println("Title: ?");
                        String title = input.get(i);
                        i++;
                        //                      System.out.println("url: ?");
                        String url = input.get(i);
                        i++;
                        String description = input.get(i);
                        i++;
                        if (daoService.insertVideo(title, url, "video", description)) {
                            prints.add("Inserting a video succeeded.");
                        } else {
                            prints.add("Inserting a video not successfull");
                        }

                    } else if (type.equals("podcast") && i + 2 < input.size()) {
//                        System.out.println("Podcasts name: ?");
                        String name = input.get(i);
                        i++;
                        //                      System.out.println("Title: ?");
                        String title = input.get(i);
                        i++;
                        //                    System.out.println("description: ?");
                        String description = input.get(i);
                        i++;
                        if (daoService.insertPodcast(name, title, description, "podcast")) {
                            prints.add("Inserting a podcast succeeded.");
                        } else {
                            prints.add("Inserting a podcast not successfull");
                        }

                    } else if (type.equals("blog") && i + 2 < input.size()) {
//                        System.out.println("Author: ?");
                        String author = input.get(i);
                        i++;
                        //                      System.out.println("Title: ?");
                        String title = input.get(i);
                        i++;
                        //                    System.out.println("url: ?");
                        String url = input.get(i);
                        i++;
                        String description = input.get(i);
                        i++;
                        if (daoService.insertBlog(author, title, url, "blogpost", description)) {
                            prints.add("Inserting a blog succeeded.");
                        } else {
                            prints.add("Inserting a blog not successfull");
                        }

                    }

                    break;
                case "quit":
                    quit = true;
                    break;
                default:
                    System.out.println("Enter a proper command (insert, find-all, quit)");
            }

        }
    }

    public List<String> getPrints() {
        return prints;
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
        }
        return tips;
    }
    
    
}
