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

import static readingtipslibrary.app.Constants.*;

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
            io.prompt(COMMANDS_LIST);
            String command = io.readLine(ENTER_COMMAND);

            switch (command) {
                case "find-type":
                    String typeToFind = io.readLine(FIND_TYPE);
                    if (!typeToFind.equals("all")) {
                        findType(typeToFind);
                    } else {
                        findAll();
                    }
                    break;

                case "find-by-name":

                    String name = io.readLine(SEARCH_NAME);

                    List<Tip> list = new ArrayList<>();
                    for (String s : TypeField.POSSIBLE_TYPES) {
                        list.addAll(daoService.findByName(name, s));
                    }
                    if (list.isEmpty()) {
                        io.prompt(FOUND_NOTHING);
                    } else {
                        io.prompt(String.format(FOUND_ENTRIES, list.size()));
                        printListOfTips(list);
                    }
                    break;

                case "find-all":
                    findAll();
                    break;
                case "edit":
                    String userSelectedType = io.readLine(EDIT_TYPE);
                    int id = io.readInt(String.format(EDIT_ID, userSelectedType));
                    edit(userSelectedType, id);
                    break;
                case "insert":
                    userSelectedType = io.readLine(INSERT_TYPE);

                    if (!isValid(userSelectedType)) {
                        io.warn(String.format(NOT_VALID_INSERT, userSelectedType));
                        break;
                    }
                    Tip selectedTipType = Tip.tipFromType(userSelectedType);
                    for (String field : selectedTipType.getFieldNames()) {
                        if (field.equals("id")) {
                            continue;
                        }
                        insertColumn(selectedTipType, field);
                    }
                    if (daoService.insert(selectedTipType)) {
                        io.success(String.format(SUCCESSFUL_INSERT, userSelectedType));
                    } else {
                        io.warn(String.format(ERROR_INSERTING, userSelectedType));
                    }
                    break;
                case "delete-type":
                    userSelectedType = io.readLine(DELETE_TYPE);

                    if (userSelectedType.equals("all")) {
                        deleteAll();
                        break;
                    }
                    if (!isValid(userSelectedType)) {
                        io.warn(String.format(DELETE_INVALID_TYPE, userSelectedType));
                        break;
                    }
                    deleteType(userSelectedType);
                    break;
                case "delete-all":
                    deleteAll();
                    break;
                case "delete-one":
                    userSelectedType = io.readLine(DELETE_ONE);
                    id = io.readInt(DELETE_ID);
                    deleteById(userSelectedType, id);
                    break;
                case "print-random-tip":
                    selectRandomTip();
                                       
                    break;
                case "quit":
                    quit = true;
                    break;
                default:
                    io.warn(PROPER_COMMAND_WARNING);
            }

        }
    }
    
    private void selectRandomTip() {
        Tip tip = daoService.selectRandomTip();
        if (tip != null) {
            io.prompt(tip.toString());
        } else {
            io.prompt("No tips were found.");
        }
    }

    private boolean isValid(String userSelectedType) {
        boolean valid = false;
        for (String tipType : TypeField.POSSIBLE_TYPES) {
            valid = valid || userSelectedType.equals(tipType);
        }
        return valid;
    }

    private String insertColumn(Tip selectedTipType, String field) {
        String insertedColumnValue = io.readLine(String.format(INSERT_COLUMN, selectedTipType.getField(field).toString()));
        if (!selectedTipType.getField(field).setContent(insertedColumnValue)) {
            io.prompt(String.format(INVALID_COLUMN, insertedColumnValue, field));
            return insertColumn(selectedTipType, field);
        } else {
            return insertedColumnValue;
        }
    }

    private void deleteAll() {
        for (String s : TypeField.POSSIBLE_TYPES) {
            deleteType(s);
        }
        io.success(DELETE_ALL_SUCCESS);
    }

    private void deleteType(String type) {
        if (daoService.deleteAll(type)) {
            io.success(String.format(DELETE_TYPE_SUCCESS, type));
        } else {
            io.warn(String.format(DELETE_TYPE_FAIL, type));
        }
    }

    private void deleteById(String type, int id) {
        if (daoService.deleteById(type, id)) {
            io.success(String.format(DELETE_ID_SUCCESS, type, id));
        } else {
            io.warn(DELETE_ID_FAIL);
        }
    }

    private void findAll() {
        for (String s : TypeField.POSSIBLE_TYPES) {
            findType(s);
        }
        io.success("Everything found");
    }

    private void findType(String type) {
        boolean legitInput = false;
        for (String allTypes : TypeField.POSSIBLE_TYPES) {
            legitInput = allTypes.equalsIgnoreCase(type);
            if (legitInput) {
                break;
            }
        }
        if (!legitInput) {
            io.warn(String.format(INVALID_COLUMN, type, "type"));
            return;
        }
        List<Tip> allFromType = daoService.findAll(type);
        if (allFromType.isEmpty()) {

        }
        io.prompt(type.substring(0, 1).toUpperCase() + type.substring(1) + "s:");
        io.prompt("-----------------------------------");
        int tipsAdded = 0;
        for (Tip tip : allFromType) {
            io.prompt(tip.toString());
            tipsAdded++;
            if (tipsAdded < allFromType.size()) {
                System.out.println();
            }
        }
        io.prompt("-----------------------------------");
        io.prompt(String.format(FOUND_TYPE, type));
    }

    private void printListOfTips(List<Tip> list) {
        for (Tip tip : list) {
            io.prompt(tip.toString() + "\n");
        }
    }

    private void edit(String type, int id) {
        if (daoService.findById(type, id) == null) {
            io.warn(EDIT_FIND_ERROR);
        } else {
            Tip tip = daoService.findById(type, id);
            io.prompt(tip.toString());
            String columnToEdit = io.readLine(EDIT_FIELD).toLowerCase();
            boolean invalidFieldName = true;
            for (String fieldName : tip.getFieldNames()) {
                if (fieldName.equals(columnToEdit)) {
                    invalidFieldName = false;
                    break;
                }
            }
            if (invalidFieldName) {
                io.warn(String.format(INVALID_COLUMN, columnToEdit, "field name"));
            } else if (columnToEdit.equals("id")) {
                io.warn(EDIT_ID_NOT_POSSIBLE);
            } else {
                String newValue = io.readLine(String.format(EDIT_NEW_VALUE, columnToEdit));
                if (tip.getField(columnToEdit).isValidContent(newValue)) {
                    if (daoService.editById(type, id, columnToEdit, newValue)) {
                        tip.getField(columnToEdit).setContent(newValue);
                        io.prompt(tip.toString());
                        io.success(EDIT_SUCCESS);
                    } else {
                        io.prompt(tip.toString());
                        io.warn(EDIT_ERROR);
                    }
                } else {
                    io.warn(String.format(INVALID_COLUMN, newValue, columnToEdit));
                }
            }
        }
    }
}
