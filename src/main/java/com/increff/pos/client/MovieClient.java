package com.increff.pos.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.increff.pos.model.Data.MovieDataList;
import com.increff.pos.service.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieClient {
    private static final String URL = "https://www.omdbapi.com";
    //    /?s=${searchQuery}&apikey=2e5a9437
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    ObjectMapper objectMapper;
    public MovieDataList getMoviesData(String keyword) throws ApiException {
        try{
            String url = URL;
            url+="/?s=" + keyword + "&apikey=2e5a9437";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> httpEntity = new HttpEntity<>(headers);
            ResponseEntity<MovieDataList> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, MovieDataList.class);
            MovieDataList movieDataList = response.getBody();
//            System.out.println("Response from OMDB API:");
//            System.out.println(objectMapper.writeValueAsString(movieDataList));
            return movieDataList;
        }
        catch (Exception e){
            throw new ApiException("Unable to get Data");
        }
    }
}
