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
public class Blogpost implements Tip {

    private String title;
    private String author;
    private String url;
    private String type;
    private ArrayList<String> relatedCourses;

    public Blogpost(String title, String url, String type) {
        this.title = title;
        this.url = url;
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
/*
Otsikko: Consistency models
Kirjoittaja: Nicola Apicella
Url: https://dev.to/napicellatwit/consistency-models-52l
Tyyppi: Blogpost
Related courses: TKT21001 Tietokannan suunnittelu, CSM13001 Distributed Systems
*/
