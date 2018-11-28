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
        fields = new HashMap<>();
        type = new TypeField();
        type.setContent("video");
        Field f;
        String[] genericFields = new String[]{"title", "description"};
        fieldNames = new String[]{"title", "description", "url"};
        for (String s : genericFields){
            f = new GenericField(s);
            fields.put(s,f);
        }
        f = new UrlField();
        fields.put(f.name,f);
    }
}
/*

Otsikko: Merge sort algorithm
Url: https://www.youtube.com/watch?v=TzeBrDU-JaY
Related courses: TKT20001 Tietorakenteet ja algoritmit
Tyyppi: video
Kommentti: Hyvä selitys merge sortin toiminnasta esimerkin avulla 
*/
