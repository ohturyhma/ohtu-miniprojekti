/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.HashMap;

/**
 * Class containing video for a podcast episode
 * @author strajama
 */
public class Video extends Tip {

     public Video(){
        type = new TypeField();
        type.setContent("video");
        String[] genericFields = new String[]{"title", "description"};
        for (String s : genericFields){
            addField(new GenericField(s));
        }
        addField(new UrlField());
    }
}
/*

Otsikko: Merge sort algorithm
Url: https://www.youtube.com/watch?v=TzeBrDU-JaY
Related courses: TKT20001 Tietorakenteet ja algoritmit
Tyyppi: video
Kommentti: Hyvä selitys merge sortin toiminnasta esimerkin avulla 
*/
