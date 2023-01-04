package com.project.server.repository.impl;

import com.project.server.entity.*;
import com.project.server.repository.UserRepository;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> findAll() {
        TypedQuery<User>query = em.createQuery("select u from User u ",User.class);
        return query.getResultList();
    }

    @Override
    public User findById(UUID id) {
        TypedQuery<User>query = em.createQuery("select u from User u where u.userid=:id",User.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
        return null;
    }
    }



    @Override
    public void save(User model) {
        if(model.getUserid() != null){
            em.merge(model);
        }
        else{
            em.persist(model);
        }
    }

    @Override
    public void remove(UUID id) {
        User user = findById(id);
        if (user != null){
            em.remove(user);
        }
    }

    @Override
    public User findbyAccDetailId(UUID ID) {
        TypedQuery<User>query = em.createQuery("select u from User u where u.AccountDetail=:id",User.class);
        query.setParameter("id",ID);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public User findbyAccLoginId(UUID ID) {
        TypedQuery<User>query = em.createQuery("select u from User u where u.LoginDetail=:id",User.class);
        query.setParameter("id",ID);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
