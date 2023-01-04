package com.project.server.repository.impl;

import com.project.server.entity.*;
import com.project.server.repository.UserLoginRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public class UserLoginRepositoryImpl implements UserLoginRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<UserLoginDetail> findAll() {
        TypedQuery<UserLoginDetail>query = em.createQuery("select u from UserLoginDetail u ",UserLoginDetail.class);
        return query.getResultList();
    }

    @Override
    public UserLoginDetail findById(UUID id) {
        TypedQuery<UserLoginDetail>query = em.createQuery("select u from UserLoginDetail u where u.id=:id",UserLoginDetail.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(UserLoginDetail model) {
        if(model.getId() != null){
            em.merge(model);
        }
        else{
            em.persist(model);
        }
    }




    @Override
    public void remove(UUID id) {
        UserLoginDetail user = findById(id);
        if (user != null){
            em.remove(user);
        }
    }

    @Override
    public UserLoginDetail findByToken(String Token) {
        TypedQuery<UserLoginDetail>query = em.createQuery("select u from UserAccountDetail u where u.Token=:token",UserLoginDetail.class);
        query.setParameter("token",Token);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
