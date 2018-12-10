/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author Vertti
 */
public class DaoService {

    private TipDao tipDao;

    public DaoService(Database database) {
        this.tipDao = new TipDao(database);
    }

    public Tip selectRandomTip() {
        List<String> orderToTryTables = returnTypesOfTablesInRandomOrder();
        List<Tip> tips = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            tips = findAll(orderToTryTables.get(i));
            if (!tips.isEmpty()) {
                break;
            }
        }
        if(tips.isEmpty()) return null;
        Random r = new Random();
        int indeksi = r.nextInt(tips.size());

        return tips.get(indeksi);

    }

    public List<Tip> findByName(String name, String type) {
        List<Tip> tips = new ArrayList<>();

        try {
            tips = tipDao.findByName(name, type);
        } catch (SQLException e) {
            return tips;
        }

        return tips;
    }

    public boolean insert(Tip tip) {
        try {
            tipDao.insert(tip);
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAll(String type) {
        List<Tip> tips = new ArrayList<>();

        try {
            tips = tipDao.findAll(type);
        } catch (SQLException e) {
            return tips;
        }

        return tips;

    }

    public boolean deleteAll(String type) {
        try {
            tipDao.deleteAll(type);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deleteById(String type, int id) {
        boolean r = false;
        try {
            r = tipDao.deleteById(type, id);
        } catch (SQLException e) {
            return false;
        }
        return r;
    }

    public Tip findById(String type, int id) {
        Tip tip;
        try {
            tip = tipDao.findById(type, id);
        } catch (SQLException e) {
            return null;
        }
        return tip;
    }

    public boolean editById(String type, int id, String column, String newContent) {
        boolean r = false;
        try {
            r = tipDao.editById(type, id, column, newContent);
        } catch (SQLException e) {
            return false;
        }
        return r;
    }

    private List<String> returnTypesOfTablesInRandomOrder() {
        List<String> order = new ArrayList<>();
        order.addAll(Arrays.asList("book", "video", "podcast", "blogpost"));
        Collections.shuffle(order);
        return order;
    }
}
