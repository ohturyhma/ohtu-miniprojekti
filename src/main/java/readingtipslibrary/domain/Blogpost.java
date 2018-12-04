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
        type = new TypeField();
        type.setContent("blogpost");
        String[] genericFields = new String[]{"author", "title", "description"};
        for (String s : genericFields){
            addField(new GenericField(s));
        }
        addField(new UrlField());
                addField(new IdField());

    }
}

/*
Otsikko: Consistency models
Kirjoittaja: Nicola Apicella
Url: https://dev.to/napicellatwit/consistency-models-52l
Tyyppi: Blogpost
Related courses: TKT21001 Tietokannan suunnittelu, CSM13001 Distributed Systems
*/
