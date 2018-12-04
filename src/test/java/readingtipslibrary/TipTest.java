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
        String valid1 = "https://web.telegram.org/#/im?p=@ohjelmistotuotanto";
        String valid2= "www.github.com/ohturyhma";
        String valid3= "http://math.aalto.fi/opetus/sovtoda/oppikirja/TodLaskJakaumat.pdf";
        String valid4= "github.com/ohturyhma";
        String valid5 = "pekka.fi";
        String unvalid1 = "";
        String unvalid2 = "pekka";
        String unvalid3 = "pekka.f";
        assertTrue(url.isValidContent(valid1));
        assertTrue(url.isValidContent(valid2));
        assertTrue(url.isValidContent(valid3));
        assertTrue(url.isValidContent(valid4));
        assertTrue(url.isValidContent(valid5));
        assertFalse(url.isValidContent(unvalid1));
        assertFalse(url.isValidContent(unvalid2));
        assertFalse(url.isValidContent(unvalid3));
    }
}
