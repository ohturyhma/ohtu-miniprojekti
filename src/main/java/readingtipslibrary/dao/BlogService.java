/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author johyry
 */
public class BlogService {
    private BlogDao blogDao;
    
    public BlogService(Database database) {
        blogDao = new BlogDao(database);
    }
    
    
    public boolean insertBlog(String author, String title, String url, String type) {
        Blogpost blogpost = new Blogpost(author, title, url, type);

        try {
            blogDao.insert(blogpost);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAll() {
        List<Tip> blogs = new ArrayList<>();
        
        try {
            blogs = blogDao.findAll();
        } catch (Exception e) {
            return blogs;
        }

        return blogs;

    }
}
