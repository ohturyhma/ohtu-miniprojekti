/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.HashMap;

/**
 * Class containing the data for a book
 *
 * @author strajama
 */
public class Book extends Tip {

    public Book(){
        type = new TypeField();
        type.setContent("book");
        String[] genericFields = new String[]{"author", "title", "isbn", "description"};
        for (String s : genericFields){
            addField(new GenericField(s));
        }
        addField(new UrlField());
        addField(new IdField());
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
