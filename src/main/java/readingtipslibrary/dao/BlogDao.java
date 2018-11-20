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
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author nroope
 */
public class BlogDao implements Dao<Blogpost> {

    private Database database;

    public BlogDao(Database database) {
        this.database = database;
    }

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
            blogs.add(new Book(author, title, url, type));
        }

        rs.close();
        stmt.close();
        connection.close();

        return blogs;
    }

    @Override
    public Tip insert(Blogpost blogspost) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO blogposts"
                + " (author, title, url, type) VALUES (?, ?, ?, ?)");
        stmt.setObject(1, blogspost.getAuthor());
        stmt.setObject(2, blogspost.getTitle());
        stmt.setObject(3, blogspost.getUrl());
        stmt.setObject(4, blogspost.getType());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
        return blogspost;
    }

}
