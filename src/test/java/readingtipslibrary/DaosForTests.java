/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.dao.Dao;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Tip;
import readingtipslibrary.domain.Video;

public class DaosForTests implements Dao {

    private List<Tip> tips;

    public DaosForTests() {
        this.tips = new ArrayList<>();
    }

    @Override
    public List findAll() {
        return tips;
    }

    public Tip insert(Book book) {
        tips.add(book);
        return book;
    }

    public Tip insert(Blogpost blog) {
        tips.add(blog);
        return blog;
    }

    public Tip insert(Podcast pod) {
        tips.add(pod);
        return pod;
    }

    public Tip insert(Video video) {
        tips.add(video);
        return video;
    }

    @Override
    public Tip insert(Object t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
