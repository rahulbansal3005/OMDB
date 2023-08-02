package com.increff.pos.service;

import com.increff.pos.dao.MovieDao;
import com.increff.pos.dao.PlaylistDao;
import com.increff.pos.pojo.MoviesPojo;
import com.increff.pos.pojo.PlaylistPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlayListService {
    @Autowired
    private PlaylistDao playlistDao;

    @Autowired
    private MovieDao movieDao;


    @Transactional(rollbackOn = ApiException.class)
    public void addPlaylist(PlaylistPojo playlistPojo){
        playlistDao.insertPlaylistPojo(playlistPojo);
    }


    @Transactional(rollbackOn = ApiException.class)
    public void addMovies(List<MoviesPojo> moviesPojoList){
        for(MoviesPojo moviesPojo:moviesPojoList){
            movieDao.insertMoviePojo(moviesPojo);
        }
    }






}
