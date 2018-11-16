/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.ArrayList;

/**
 *
 * @author strajama
 */
public class Book implements Tip {

    private String author;
    private String title;
    private String type;
    private String isbn;
    private ArrayList<String> tags;
    private ArrayList<String> preliminaryCourses;
    private ArrayList<String> relatedCourses;

    public Book(String author, String title, String type) {
        this.author = author;
        this.title = title;
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
/*
Kirjoittaja: Robert Martin
Otsikko: Clean Code: A Handbook of Agile Software Craftsmanship
Tyyppi: Kirja
ISBN: 978-0132350884
Tagit: Ohjelmointi, design patterns
Esitietokurssit: TKT10003 Ohjelmoinnin jatkokurssi
Related courses: TKT20006 Ohjelmistotuotanto
*/
