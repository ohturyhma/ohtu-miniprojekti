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
public class Podcast implements Tip {

    private String author;
    private String podcastName;
    private String title;
    private String description;
    private String type;
    private ArrayList<String> tags;
    private ArrayList<String> relatedCourses;

    public Podcast(String podcastName, String title, String description, String type) {
        this.podcastName = podcastName;
        this.title = title;
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return author + " " + podcastName + " " + description + " " + type;
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
