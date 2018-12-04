/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.UrlField;
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
        //
    }

    @Test
    public void bookToString() {
        //
    }

    @Test
    public void blogpostToString() {
        //
    }

    @Test
    public void podcastToString() {
        //
    }

    @Test
    public void videoToString() {
        //
    }

    @Test
    public void bookSetters() {
        //
    }

    @Test
    public void blogpostSetters() {
        //
    }

    @Test
    public void podcastSetters() {
//
    }

    @Test
    public void videoSetters() {
        //;
    }

    @Test
    public void urlFieldTest() {
        UrlField url = new UrlField();
        assertTrue(url.isValidContent("https://web.telegram.org/#/im?p=@ohjelmistotuotanto"));
        assertTrue(url.isValidContent("www.github.com/ohturyhma"));
        assertTrue(url.isValidContent("http://math.aalto.fi/opetus/sovtoda/oppikirja/TodLaskJakaumat.pdf"));
        assertTrue(url.isValidContent("github.com/ohturyhma"));
        assertTrue(url.isValidContent("pekka.fi"));
        assertTrue(url.isValidContent(""));
        assertFalse(url.isValidContent("pekka"));
        assertFalse(url.isValidContent("pekka.f"));
        assertFalse(url.isValidContent("pekka.fi9"));
    }
}
