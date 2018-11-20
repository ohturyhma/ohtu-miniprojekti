/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.PodcastDao;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author johyry
 */
public class PodcastService {
    
    private PodcastDao podcastDao;
    
    public PodcastService(Database database) {
        this.podcastDao = new PodcastDao(database);
    }
    
    
    public boolean insertPodcast(String author, String title, String description, String type) {
        Podcast podcast = new Podcast(author, title, description, type);

        try {
            podcastDao.insert(podcast);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAll() {
        List<Tip> podcasts = new ArrayList<>();
        
        try {
            podcasts = podcastDao.findAll();
        } catch (Exception e) {
            return podcasts;
        }

        return podcasts;

    }
}
