/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Tip;
import readingtipslibrary.domain.Video;

/**
 *
 * @author johyry
 */
public class DaoService {

    private Dao bookDao;
    private Dao blogDao;
    private Dao podcastDao;
    private Dao videoDao;

    public DaoService(Database database) {
        this.bookDao = new BookDao(database);
        this.blogDao = new BlogDao(database);
        this.podcastDao = new PodcastDao(database);
        this.videoDao = new VideoDao(database);

    }

    // book methods
    public boolean insertBook(String author, String title, String isbn, String type) {
        Book book = new Book(author, title, isbn, type);

        try {
            bookDao.insert(book);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAllBooks() {
        List<Tip> books = new ArrayList<>();

        try {
            books = bookDao.findAll();
        } catch (Exception e) {
            return books;
        }

        return books;

    }

    public boolean destroyAllBooks() {
        try {
            bookDao.destroyAll();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // BLOG METHODS
    public boolean insertBlog(String author, String title, String url, String type) {
        Blogpost blogpost = new Blogpost(author, title, url, type);

        try {
            blogDao.insert(blogpost);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAllBlogs() {
        List<Tip> blogs = new ArrayList<>();

        try {
            blogs = blogDao.findAll();
        } catch (Exception e) {
            return blogs;
        }

        return blogs;

    }

    public boolean destroyAllBlogs() {
        try {
            blogDao.destroyAll();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // podcast methods
    public boolean insertPodcast(String podcastName, String title, String description, String type) {
        Podcast podcast = new Podcast(podcastName, title, description, type);

        try {
            podcastDao.insert(podcast);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAllPodcasts() {
        List<Tip> podcasts = new ArrayList<>();

        try {
            podcasts = podcastDao.findAll();
        } catch (Exception e) {
            return podcasts;
        }

        return podcasts;

    }

    public boolean destroyAllPodcasts() {
        try {
            podcastDao.destroyAll();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // video methods
    public boolean insertVideo(String title, String url, String type) {
        Video video = new Video(title, url, type);

        try {
            videoDao.insert(video);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAllVideos() {
        List<Tip> videos = new ArrayList<>();

        try {
            videos = videoDao.findAll();
        } catch (Exception e) {
            return videos;
        }

        return videos;

    }

    public boolean destroyAllVideos() {
        try {
            videoDao.destroyAll();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
