package com.increff.pos.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class MoviesPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    private String title;
    private String year;
    private String poster;
    private String imdbID;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlistId", nullable = false)
    private PlaylistPojo playlist;
}
