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
import java.util.Arrays;
import java.util.List;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author Vertti
 */
public class TipDao {

    private Database database;

    public TipDao(Database database) {
        this.database = database;
    }

    public List<Tip> findAll(String type) throws SQLException {

        Tip t;
        String table;
        switch (type) {
            case "book":
                table = "books";
                break;
            case "video":
                table = "videos";
                break;
            case "podcast":
                table = "podcasts";
                break;
            case "blogpost":
                table = "blogposts";
                break;
            default:
                throw new SQLException("unexpected value provided for table name");
        }

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table);// + type + "s");

        List<Tip> tips = new ArrayList<>();

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            t = Tip.tipFromType(type);
            for (String s : t.getFieldNames()) {
                t.getField(s).setContent(rs.getString(s));
            }
            tips.add(t);
        }

        rs.close();
        stmt.close();
        connection.close();

        return tips;
    }

    public Tip insert(Tip t) throws SQLException {

        String table;
        switch (t.getType().getContent()) {
            case "book":
                table = "books";
                break;
            case "video":
                table = "videos";
                break;
            case "podcast":
                table = "podcasts";
                break;
            case "blogpost":
                table = "blogposts";
                break;
            default:
                throw new SQLException("unexpected value provided for table name");
        }

        Connection connection = database.getConnection();
        String statementString = "INSERT INTO " + table + "(";
//        String statementString = "INSERT INTO " + t.getType().getContent() + "s (";
        String[] fieldNames = t.getFieldNames();
        
        

        for (int i = 0; i < fieldNames.length; ++i) {

            if (i != 0) {
                statementString += ", ";
            }
            statementString += fieldNames[i];
        }
        statementString += ") VALUES (";
        for (int i = 0; i < fieldNames.length; ++i) {
            if (i != 0) {
                statementString += ", ";
            }
            statementString += "?";
        }
        statementString += ")";
        PreparedStatement stmt = connection.prepareStatement(statementString);
        for (int i = 0; i < fieldNames.length; ++i) {
            stmt.setObject(i + 1, t.getField(fieldNames[i]).getContent());
        }

        stmt.executeUpdate();
        stmt.close();
        connection.close();
        return t;
    }

    public void deleteAll(String type) throws SQLException {

        String table;
        switch (type) {
            case "book":
                table = "books";
                break;
            case "video":
                table = "videos";
                break;
            case "podcast":
                table = "podcasts";
                break;
            case "blogpost":
                table = "blogposts";
                break;
            default:
                throw new SQLException("unexpected value provided for table name");
        }

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM " + table);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    // kesken!
    public void findByTitle(String title, String type) throws SQLException {

        String table;
        switch (type) {
            case "book":
                table = "books";
                break;
            case "video":
                table = "videos";
                break;
            case "podcast":
                table = "podcasts";
                break;
            case "blogpost":
                table = "blogposts";
                break;
            default:
                throw new SQLException("unexpected value provided for table name");
        }
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT FROM " + table + " WHERE title=?");
        stmt.setObject(1, title);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}
