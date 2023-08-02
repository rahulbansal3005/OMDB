package com.increff.pos.dao;


import com.increff.pos.pojo.MoviesPojo;
import com.increff.pos.pojo.PlaylistPojo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class PlaylistDao extends AbstractDao{

    @PersistenceContext
    private EntityManager em;

    public void insertPlaylistPojo(PlaylistPojo playlistPojo){
        em.persist(playlistPojo);
    }



}
