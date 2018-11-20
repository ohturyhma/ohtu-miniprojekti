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
import readingtipslibrary.domain.Tip;
import readingtipslibrary.domain.Video;

/**
 *
 * @author nroope
 */
public class VideoDao implements Dao<Video> {

    private Database database;

    public VideoDao(Database database) {
        this.database = database;
    }

    @Override
    public List<Tip> findAll() throws SQLException {
        
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM videos");

        List<Tip> videos = new ArrayList<>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String title = rs.getString("title");
            String url = rs.getString("url");
            String type = rs.getString("Type");
            videos.add(new Video(title, url, type));
            System.out.println(title + " " + url + " " + type);
        }

        rs.close();
        stmt.close();
        connection.close();

        return videos;

    }

    @Override
    public Video insert(Video video) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO videos"
                + " (url, title, type) VALUES (?, ?, ?)");
        stmt.setObject(1, video.getUrl());
        stmt.setObject(2, video.getTitle());
        stmt.setObject(3, video.getType());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
        return video;
    }

}
