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
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Tip;

/**
 * Data Access Object for Blogposts
 *
 * @author nroope
 */
public class BlogDao implements Dao<Blogpost> {

    private Database database;

    /**
     * Constructor for the BlogDAO
     *
     * @param database The database which the DAO uses
     *
     */
    public BlogDao(Database database) {
        this.database = database;
    }

    /**
     * Creates a list of blogposts from the blogposts table in the database
     *
     * @return A list of all blogposts from the DAO's database
     * @throws SQLException
     */
    @Override
    public List<Tip> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM blogposts");

        List<Tip> blogs = new ArrayList<>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String author = rs.getString("author");
            String title = rs.getString("title");
            String url = rs.getString("url");
            String type = rs.getString("Type");
            blogs.add(new Blogpost(author, title, url, type));
        }

        rs.close();
        stmt.close();
        connection.close();

        return blogs;
    }

    /**
     * Adds a Blopost into the blopost table into the database and returns it
     *
     * @param blogpost The Blogpost to be added into the database
     * @return The blogpost that was added to the table (Same as the parameter)
     * @throws SQLException
     */
    @Override
    public Tip insert(Blogpost blogpost) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO blogposts"
                + " (author, title, url, type) VALUES (?, ?, ?, ?)");
        stmt.setObject(1, blogpost.getAuthor());
        stmt.setObject(2, blogpost.getTitle());
        stmt.setObject(3, blogpost.getUrl());
        stmt.setObject(4, blogpost.getType());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
        return blogpost;
    }
    
    /**
     * Deletes all data in the table blogposts
     * 
     * @throws SQLException 
     */
    @Override
    public void destroyAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("TRUNCATE TABLE blogposts"); 
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}