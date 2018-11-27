/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.ArrayList;

/**
 * Class containing video for a podcast episode
 * @author strajama
 */
public class Video implements Tip {

    private String title;
    private String url;
    private ArrayList<String> relatedCourses;
    private String type;
    private String comment;
    private String description;
    /**
     * Constructor for a video
     * @param title The title of the video
     * @param url The URL at which the video is found
     * @param type The type of the video
     */
    public Video(String title, String url, String type, String description) {
        this.title = title;
        this.url = url;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    @Override
    public String toString() {
        return title + ", " + url + ", " + type + ", " + description;
    }

}
/*

Otsikko: Merge sort algorithm
Url: https://www.youtube.com/watch?v=TzeBrDU-JaY
Related courses: TKT20001 Tietorakenteet ja algoritmit
Tyyppi: video
Kommentti: Hyvä selitys merge sortin toiminnasta esimerkin avulla 
*/
