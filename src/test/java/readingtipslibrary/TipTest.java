/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Video;

/**
 *
 * Testing classes that implement Tip-interface
 */
public class TipTest {

    private Book book;
    private Blogpost blog;
    private Podcast pod;
    private Video video;

    @Before
    public void setup() {
        book = new Book("author", "title", "isbn", "type", "description");
        blog = new Blogpost("author", "title", "url", "type", "description");
        pod = new Podcast("podcastName", "title", "type", "description");
        video = new Video("title", "url", "type", "description");
    }

    @Test
    public void bookToString() {
        assertEquals("author, title, isbn, type, description", book.toString());
    }

    @Test
    public void blogpostToString() {
        assertEquals("author, title, url, type, description", blog.toString());
    }

    @Test
    public void podcastToString() {
        assertEquals("podcastName, title, type, description", pod.toString());
    }

    @Test
    public void videoToString() {
        assertEquals("title, url, type, description", video.toString());
    }

    @Test
    public void bookSetters() {
        book.setAuthor("uusi");
        book.setIsbn("123");
        book.setTitle("testi");
        assertEquals("uusi", book.getAuthor());
        assertEquals("123", book.getIsbn());
        assertEquals("testi", book.getTitle());
    }

    @Test
    public void blogpostSetters() {
        blog.setAuthor("uusi");
        blog.setUrl("123");
        blog.setTitle("testi");
        assertEquals("uusi", blog.getAuthor());
        assertEquals("123", blog.getUrl());
        assertEquals("testi", blog.getTitle());
    }

    @Test
    public void podcastSetters() {
        pod.setAuthor("uusi");
        pod.setDescription("123");
        pod.setPodcastName("testi");
        pod.setTitle("uusitesti");
        assertEquals("uusi", pod.getAuthor());
        assertEquals("123", pod.getDescription());
        assertEquals("testi", pod.getPodcastName());
        assertEquals("uusitesti", pod.getTitle());
    }

    @Test
    public void videoSetters() {
        video.setUrl("uusi");
        video.setTitle("testi");
        assertEquals("uusi", video.getUrl());
        assertEquals("testi", video.getTitle());
    }
}
