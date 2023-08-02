package com.increff.pos.dto;

import com.increff.pos.client.MovieClient;
import com.increff.pos.model.Data.MovieDataList;
import com.increff.pos.pojo.MoviesPojo;
import com.increff.pos.pojo.PlaylistPojo;
import com.increff.pos.service.ApiException;
import com.increff.pos.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistDto {

    @Autowired
    private MovieClient movieClient;

    @Autowired
    private PlayListService playListService;

    public MovieDataList getMovieList(String keyword) throws ApiException {
        MovieDataList movieDataList = movieClient.getMoviesData(keyword);
        if (movieDataList.getMovieDataList().isEmpty()) {
            System.out.println("list size zero");
        }
        return movieDataList;
    }

    public void savePlaylist(String keyword, Boolean isPrivate) throws ApiException {
        MovieDataList movieDataList = movieClient.getMoviesData(keyword);
        if (movieDataList.getMovieDataList().isEmpty()) {
            System.out.println("list size zero, cannot insert playlist");
        } else {
            PlaylistPojo playlistPojo = new PlaylistPojo();
            playlistPojo.setIsPrivate(isPrivate);
            List<MoviesPojo> movies = new ArrayList<>();
            for (MovieDataList.MovieData movieData : movieDataList.getMovieDataList()) {
                MoviesPojo moviePojo = new MoviesPojo();
                moviePojo.setTitle(movieData.getTitle());
                moviePojo.setYear(movieData.getYear());
                moviePojo.setImdbID(movieData.getImdbID());
                moviePojo.setPoster(movieData.getPoster());
                moviePojo.setPlaylist(playlistPojo);
                movies.add(moviePojo);
            }

            playlistPojo.setMovies(movies);
            playListService.addPlaylist(playlistPojo);
            playListService.addMovies(movies);
        }
    }
}
