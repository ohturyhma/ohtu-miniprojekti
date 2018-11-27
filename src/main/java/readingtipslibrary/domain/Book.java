/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.ArrayList;

/**
 * Class containing the data for a book
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
    private String description;

    /**
     * Constructor for a book
     *
     * @param author The author of the book
     * @param title The title of the book
     * @param isbn The ISBN-code for the book
     * @param type The type of the book
     * @param description The description of the book
     */
    public Book(String author, String title, String isbn, String type, String description) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.type = type;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + isbn + ", " + type + ", " + description;
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
