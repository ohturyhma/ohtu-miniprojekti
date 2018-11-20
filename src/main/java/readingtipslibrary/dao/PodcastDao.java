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
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Tip;

/**
 * Data Access Object for Podcasts
 *
 * @author nroope
 */
public class PodcastDao implements Dao<Podcast> {

    private Database database;
     /**
     * Constructor for the PodcastDAO
     *
     * @param database The database which the DAO uses
     *
     */
    public PodcastDao(Database database) {
        this.database = database;
    }
    /**
     * Creates a list of Podcast objects from the podcast table in the database
     *
     * @return A list of all podcasts from the DAO's database
     * @throws SQLException
     */
    @Override
    public List<Tip> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM podcasts");

        List<Tip> podcasts = new ArrayList<>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String author = rs.getString("author");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String type = rs.getString("type");
            podcasts.add(new Podcast(author, title, description, type));
        }

        rs.close();
        stmt.close();
        connection.close();

        return podcasts;

    }
    /**
     * Adds a Podcast into the podcasts table in the database and returns it
     * @param podcast The Podcast to be added into the database
     * @return The podcast that was added to the table (Same as the parameter)
     * @throws SQLException
     */
    @Override
    public Podcast insert(Podcast podcast) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO podcasts"
                + " (author, title, description, type) VALUES (?, ?, ?, ?)");
        stmt.setObject(1, podcast.getAuthor());
        stmt.setObject(2, podcast.getTitle());
        stmt.setObject(3, podcast.getDescription());
        stmt.setObject(4, podcast.getType());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
        return podcast;
    }

}
