package com.increff.pos.controller;

import com.increff.pos.dto.PlaylistDto;
import com.increff.pos.model.Data.MovieDataList;
import com.increff.pos.model.Form.PlaylistForm;
import com.increff.pos.service.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "/api")
public class PlaylistApiController {
    @Autowired
    private PlaylistDto dto;

    @ApiOperation(value = "Gets Movie list based on Keyword")
    @RequestMapping(path = "/movie", method = RequestMethod.POST)
    public MovieDataList getMovies(@RequestBody String keyword) throws ApiException {
        return dto.getMovieList(keyword);
    }

    @ApiOperation(value = "Saves playlist")
    @RequestMapping(path = "/save-playlist", method = RequestMethod.POST)
    public void savePlaylist(@RequestBody PlaylistForm playlistForm) throws ApiException {
        dto.savePlaylist(playlistForm.getKeyword(),playlistForm.getIsPrivate());
    }
}
