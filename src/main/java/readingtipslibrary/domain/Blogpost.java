/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.HashMap;



/**
 * 
 * @author Vertti
 */
public class Blogpost extends Tip {
    
    public Blogpost(){
        fields = new HashMap<>();
        type = new TypeField();
        type.setContent("blogpost");
        Field f;
        String[] genericFields = new String[]{"author", "title", "description"};
        fieldNames = new String[]{"author", "title", "description", "url"};
        for (String s : genericFields){
            f = new GenericField(s);
            fields.put(s,f);
        }
        f = new UrlField();
        fields.put(f.name,f);
    }
}

/*
Otsikko: Consistency models
Kirjoittaja: Nicola Apicella
Url: https://dev.to/napicellatwit/consistency-models-52l
Tyyppi: Blogpost
Related courses: TKT21001 Tietokannan suunnittelu, CSM13001 Distributed Systems
*/
