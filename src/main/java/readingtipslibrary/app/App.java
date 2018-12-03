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
import readingtipslibrary.domain.TypeField;

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
            System.out.println();
            io.print("Commands: insert, find-type, find-all, delete-type, delete-all, quit");
            String command = io.readLine("Enter command: ");

            switch (command) {
                case "find-type":
                    String typeToFind = io.readLine("What do you want to find? (book, blog, podcast, video or all)");
                    if (!typeToFind.equals("all")) {
                        findType(typeToFind);
                    } else {
                        findAll();
                    }
                    break;

                case "find-all":
                    findAll();
                    break;
                case "insert":
                    String type = io.readLine("What do you want to insert? (book, blog, podcast, video): ");

                    boolean valid = false;
                    for (String s : TypeField.POSSIBLE_TYPES) {
                        valid = valid || type.equals(s);
                    }
                    if (!valid) {
                        io.print(type + " is not a valid type to insert.");
                        break;
                    }
                    Tip t = Tip.tipFromType(type);
                    String s;
                    boolean loop;
                    for (String field : t.getFieldNames()) {
                        loop = true;
                        while (loop) {
                            s = io.readLine(t.getField(field).toString() + "?");
                            if (!t.getField(field).setContent(s)) {
                                io.print("'" + s + "' is not a valid " + field + ".");
                            } else {
                                loop = false;
                            }
                        }
                    }
                    if (daoService.insert(t)) {
                        io.print("Successfully added a " + type + "!");
                    } else {
                        io.print("There was a problem with adding the " + type + ".");
                    }
                    break;
                case "delete-type":
                    type = io.readLine("What type of tips do you want to delete? Command deletes all of them. (book, blog, podcast, video or all): ");

                    if (type.equals("all")) {
                        deleteAll();
                        break;
                    }
                    valid = false;
                    for (String string : TypeField.POSSIBLE_TYPES) {
                        valid = valid || type.equals(string);
                    }
                    if (!valid) {
                        io.print(type + " is not a valid type to delete.");
                        break;
                    }
                    deleteType(type);
                    break;
                case "delete-all":
                    deleteAll();
                    break;
                case "quit":
                    quit = true;
                    break;
                default:
                    io.print("Enter a proper command (insert, find-type, find-all, delete-type, delete-all, quit)");
            }

        }
    }

    private void deleteAll() {
        for (String s : TypeField.POSSIBLE_TYPES) {
            deleteType(s);
        }
    }

    private void deleteType(String type) {
        if (daoService.deleteAll(type)) {
            io.print("Deleting all " + type + "s successful!");
        } else {
            io.print("There was a problem with deleting all " + type + "s.");
        }
    }

    private void findAll() {
        for (String s : TypeField.POSSIBLE_TYPES) {
            findType(s);
        }
    }

    private void findType(String type) {
        List<Tip> allFromType = daoService.findAll(type);
        io.print(type + "s:");
        for (Tip tip : allFromType) {
            io.print(tip.toString());
        }
        System.out.println();
    }
}
