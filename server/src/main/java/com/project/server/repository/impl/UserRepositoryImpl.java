package com.project.server.repository.impl;

import com.project.server.model.UserModel;
import com.project.server.repository.UserRepository;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<UserModel> findAll() {
        TypedQuery<UserModel>query = em.createQuery("select u from UserModel u ",UserModel.class);
        return query.getResultList();
    }

    @Override
    public UserModel findById(UUID id) {
        TypedQuery<UserModel>query = em.createQuery("select u from Usermodel u where u.UserID=:id",UserModel.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
        return null;
    }
    }

    @Override
    public void save(UserModel model) {
        if(model.getUserID() != null){
            em.merge(model);
        }
        else{
            em.persist(model);
        }
    }

    @Override
    public void remove(UUID id) {
        UserModel User = findById(id);
        if (User != null){
            em.remove(User);
        }
    }

    @Override
    public UserModel findbyToken(String Token) {
        TypedQuery<UserModel>query = em.createQuery("select u from Usermodel u where u.Token=:Token",UserModel.class);
        query.setParameter("Token",Token);
        try{
            return query.getSingleResult();
        }catch(NoResultException e){
        return null;
    }
    }
}
