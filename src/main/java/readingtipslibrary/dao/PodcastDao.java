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
import readingtipslibrary.domain.Video;

/**
 *
 * @author nroope
 */
public class PodcastDao implements Dao<Podcast>{

    private Database database;

    public PodcastDao(Database database) {
        this.database = database;
    }

    @Override
    public List<Tip> findAll() throws SQLException {
        
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM podcasts");

        List<Tip> podcasts = new ArrayList<>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String type = rs.getString("type");
            podcasts.add(new Podcast(name, title, description, type));
        }

        rs.close();
        stmt.close();
        connection.close();

        return podcasts;

    }

    @Override
    public Podcast insert(Podcast podcast) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO podcasts"
                + " (name, title, description, type) VALUES (?, ?, ?, ?)");
        stmt.setObject(1, podcast.getPodcastName());
        stmt.setObject(2, podcast.getTitle());
        stmt.setObject(3, podcast.getDescription());
        stmt.setObject(4, podcast.getType());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
        return podcast;
    }

}
