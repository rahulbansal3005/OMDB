package com.increff.pos.dao;


import com.increff.pos.pojo.MoviesPojo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class MovieDao {

    @PersistenceContext
    private EntityManager em;


    public void insertMoviePojo(MoviesPojo moviesPojo){
        em.persist(moviesPojo);
    }
}
