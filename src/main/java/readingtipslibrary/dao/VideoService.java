/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.VideoDao;
import readingtipslibrary.domain.Tip;
import readingtipslibrary.domain.Video;

/**
 *
 * @author johyry
 */
public class VideoService {

    private VideoDao videoDao;

    public VideoService(Database database) {
        this.videoDao = new VideoDao(database);
    }

    public boolean insertVideo(String title, String url, String type) {
        Video video = new Video(title, url, type);

        try {
            videoDao.insert(video);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAll() {
        List<Tip> videos = new ArrayList<>();
        
        try {
            videos = videoDao.findAll();
        } catch (Exception e) {
            return videos;
        }

        return videos;

    }
    
    public boolean destroyAll(){
        try{
            videoDao.destroyAll();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
