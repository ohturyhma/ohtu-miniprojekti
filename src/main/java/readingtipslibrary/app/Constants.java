/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.app;

/**
 *
 * @author User
 */
public class Constants {

    public static final String COMMANDS_LIST = "Commands: \n-insert\n-edit\n-find-by-name\n-find-type\n-find-all\n-delete-type\n-delete-all\n-delete-one\n-print-random-tip\n-quit";
    public static final String ENTER_COMMAND = "Enter command: ";
    public static final String FIND_TYPE = "What do you want to find? (book, blogpost, podcast, video, all)";
    public static final String SEARCH_NAME = "Enter name (or part of a name): ";
    public static final String FOUND_ENTRIES = "Found %s entries";
    public static final String FOUND_TYPE = "Every %s found";
    public static final String FOUND_NOTHING = "Found no entries for %s";
    public static final String EDIT_TYPE = "What do you want to edit? (book, blogpost, podcast, video)";
    public static final String EDIT_FIELD = "What do you want to edit?";
    public static final String EDIT_ID = "Enter id of %s you want to edit";
    public static final String EDIT_ID_NOT_POSSIBLE = "Id cannot be edited.";
    public static final String EDIT_NEW_VALUE = "Enter a new value for %s.";
    public static final String EDIT_SUCCESS = "Editing was successful!";
    public static final String EDIT_ERROR = "An error occured while editing.";
    public static final String EDIT_FIND_ERROR = "An error occured while finding the tip for editing. The tip might not exist or type or id is wrong.";
    public static final String INSERT_TYPE = "What do you want to insert? (book, blogpost, podcast, video)";
    public static final String NOT_VALID_INSERT = "%s is not a valid type to insert.";
    public static final String INSERT_COLUMN = "%s ?";
    public static final String INVALID_COLUMN = "%s is not a valid %s.";
    public static final String SUCCESSFUL_INSERT = "Successfully added a %s!";
    public static final String ERROR_INSERTING = "There was a problem with adding the %s.";
    public static final String DELETE_TYPE = "What type of tips do you want to delete? (book, blogpost, podcast, video, all)";
    public static final String DELETE_WARN = "WARNING: deletes every entry of type %s.";
    public static final String DELETE_INVALID_TYPE = "%s is not a valid type to delete.";
    public static final String DELETE_ONE = "What type of tip do you want to delete? (book, blogpost, podcast, video)";
    public static final String DELETE_ID = "What id-number do you want to delete?";
    public static final String PROPER_COMMAND_WARNING = "Enter a proper command (insert, find-type, find-all, delete-type, delete-all, delete-one, quit";
    public static final String DELETE_ALL_SUCCESS = "Everything deleted!";
    public static final String DELETE_TYPE_SUCCESS = "Deleting all %ss successful!";
    public static final String DELETE_TYPE_FAIL = "There was a problem with deleting all %ss.";
    public static final String DELETE_ID_SUCCESS = "Deleting %s with id %s was succesful!";
    public static final String DELETE_ID_FAIL = "An error occured during delete.";
}
