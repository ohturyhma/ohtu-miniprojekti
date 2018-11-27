/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Tip;

/**
 * Data Access Object for Books
 *
 * @author nroope
 */
public class BookDao implements Dao<Book> {

    private Database database;

    /**
     * Constructor for the BookDAO
     *
     * @param database The database which the DAO uses
     *
     */
    public BookDao(Database database) {
        this.database = database;
    }

    /**
     * Creates a list of Book objects from the books table in the database
     *
     * @return A list of all books from the DAO's database
     * @throws SQLException
     */
    @Override
    public List<Tip> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM books");

        List<Tip> books = new ArrayList<>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String author = rs.getString("author");
            String title = rs.getString("title");
            String isbn = rs.getString("isbn");
            String type = rs.getString("Type");
            books.add(new Book(author, title, isbn, type));
        }

        rs.close();
        stmt.close();
        connection.close();

        return books;
    }

    /**
     * Adds a Book into the books table in the database and returns it
     *
     * @param book The Book to be added into the database
     * @return The book that was added to the table (Same as the parameter)
     * @throws SQLException
     */
    @Override
    public Tip insert(Book book) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO books"
                + " (author, title, isbn, type) VALUES (?, ?, ?, ?)");
        stmt.setObject(1, book.getAuthor());
        stmt.setObject(2, book.getTitle());
        stmt.setObject(3, book.getIsbn());
        stmt.setObject(4, book.getType());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
        return book;
    }

    /**
     * Deletes all data in the table books
     * 
     * @throws SQLException 
     */
    @Override
    public void destroyAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("TRUNCATE TABLE books"); 
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}
