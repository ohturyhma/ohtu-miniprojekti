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
        fields = new HashMap<>();
        type = new TypeField();
        type.setContent("book");
        Field f;
        String[] genericFields = new String[]{"description", "isbn", "title", "author"};
        fieldNames = new String[]{"author", "title", "description", "isbn", "url"};
        for (String s : genericFields){
            f = new GenericField(s);
            fields.put(s,f);
        }
        f = new UrlField();
        fields.put(f.name,f);
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
