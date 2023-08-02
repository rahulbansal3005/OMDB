package com.increff.pos.model.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDataList {
    @JsonProperty("Search")
    List<MovieData> movieDataList;
    @JsonProperty("totalResults")
    Integer totalResults;
    @JsonProperty("Response")
    String response;

    @Getter
    @Setter
    public static class MovieData {
        @JsonProperty("Title")
        private String title;
        @JsonProperty("Year")
        private String year;
        @JsonProperty("Poster")
        private String poster;

        @JsonProperty("imdbID")
        private String imdbID;

        @JsonProperty("Type")
        private String type;

    }


}
