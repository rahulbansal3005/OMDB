package com.increff.pos.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class PlaylistPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playlistId;
    @Column(nullable = false)
    private Boolean isPrivate;

    // Add a One-to-Many relationship with moviesPojo
    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MoviesPojo> movies = new ArrayList<>();
}
