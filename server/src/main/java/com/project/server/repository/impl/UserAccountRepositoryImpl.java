package com.project.server.repository.impl;

import com.project.server.entity.UserAccountDetail;
import com.project.server.entity.UserLoginDetail;
import com.project.server.repository.UserAccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<UserAccountDetail> findAll() {
        TypedQuery<UserAccountDetail> query = em.createQuery("select u from UserAccountDetail u ",UserAccountDetail.class);
        return query.getResultList();
    }

    @Override
    public UserAccountDetail findById(UUID id) {
        TypedQuery<UserAccountDetail>query = em.createQuery("select u from UserAccountDetail u where u.id=:id",UserAccountDetail.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(UserAccountDetail model) {
        if(model.getId() != null){
            em.merge(model);
        }
        else{
            em.persist(model);
        }
    }

    @Override
    public void remove(UUID id) {
        UserAccountDetail user = findById(id);
        if (user != null){
            em.remove(user);
        }
    }
}
