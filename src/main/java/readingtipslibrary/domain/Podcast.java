/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.HashMap;

/**
 * Class containing data for a podcast episode
 *
 * @author strajama
 */
public class Podcast extends Tip {

    public Podcast() {
        type = new TypeField();
        type.setContent("podcast");
        String[] genericFields = new String[]{"name", "title", "description"};
        for (String s : genericFields) {
            addField(new GenericField(s));
        }
        addField(new UrlField());
        addField(new IdField());
         
    }
}
/*
Author: Sami Honkonen
Podcastin nimi: Boss Level Podcast
Otsikko: Jim Benson on Personal Kanban, Lean Coffee and collaboration
Kuvaus: "Personal Kanban, which is an approach to dealing with the overload of stuff you need to deal with. 
  We dig into into its two simple rules, visualizing work and limiting work in progress. 
  We then walk through Lean Coffee, which is a simple and effective way to run your meetings."
Tyyppi: Podcast
Tagit: Kanban, Lean Coffee
Related courses: TKT20006 Ohjelmistotuotanto
 */
