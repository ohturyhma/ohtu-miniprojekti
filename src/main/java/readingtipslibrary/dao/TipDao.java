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

/**
 *
 * @author Vertti
 */
public class TipDao {

    private Database database;

    public TipDao(Database database) {
        this.database = database;
    }

    public List<Tip> findByName(String name, String type) throws SQLException {
        Tip t;

        String table = getTableName(type);

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table + " WHERE title LIKE ?");// + type + "s");
        name = "%" + name + "%";
        stmt.setObject(1, name);

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

    public List<Tip> findAll(String type) throws SQLException {

        Tip t;
        String table = getTableName(type);

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

        String table = getTableName(t.getType().getContent());

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

        String table = getTableName(type);

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM " + table);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
<<<<<<< HEAD

=======
    // kesken
>>>>>>> 79d3075b30ebf50e5515da363233e8bf00ed9b43
    public boolean deleteById(String type, int id) throws SQLException {
        String table = getTableName(type);
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM " + table + " WHERE id=?");
        stmt.setObject(1, id);
        int r = stmt.executeUpdate();
        stmt.close();
        connection.close();
        return r == 1;
    }
//kesken
    public boolean editById(String type, int id, String column, String newContent) throws SQLException {
        String table = getTableName(type);
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("UPDATE " + table + " SET "+column+"=? WHERE id=?");
        stmt.setObject(1, newContent);
        stmt.setObject(2, id);
        int r = stmt.executeUpdate();
        stmt.close();
        connection.close();
        return r == 1;
    }

    public Tip findById(String type, int id) throws SQLException {
        String table = getTableName(type);
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table + " WHERE id=?");
        stmt.setObject(1, id);
        ResultSet rs = stmt.executeQuery();
        Tip tip = Tip.tipFromType(type);
        for (String s : tip.getFieldNames()) {
            tip.getField(s).setContent(rs.getString(s));
        }
        rs.close();
        stmt.close();
        connection.close();
        return tip;
    }

    private String getTableName(String type) throws SQLException {
        String table;
        switch (type) {
            case "book":
                table = "books";
                return table;
            case "video":
                table = "videos";
                return table;
            case "podcast":
                table = "podcasts";
                return table;
            case "blogpost":
                table = "blogposts";
                return table;
            default:
                throw new SQLException("unexpected value provided for table name");
        }

    }
    

}
