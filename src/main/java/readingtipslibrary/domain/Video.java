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
public class Video implements Tip {

    private String title;
    private String url;
    private ArrayList<String> relatedCourses;
    private String type;
    private String comment;

    public Video(String title, String url, String type) {
        this.title = title;
        this.url = url;
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
/*

Otsikko: Merge sort algorithm
Url: https://www.youtube.com/watch?v=TzeBrDU-JaY
Related courses: TKT20001 Tietorakenteet ja algoritmit
Tyyppi: video
Kommentti: Hyvä selitys merge sortin toiminnasta esimerkin avulla 
*/
