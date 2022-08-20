package com.example.phuong.vno.dao.impl;

import com.example.phuong.vno.dao.VnoDAO;
import com.example.phuong.vno.model.entity.VnoEntity;
import com.example.phuong.vno.persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class VnoDAOImpl implements VnoDAO {

    private final EntityManager em;

    public VnoDAOImpl(PersistenceUtil persistenceUtil) {
        this.em = persistenceUtil.getEntityManager();
    }


    @Transactional(Transactional.TxType.SUPPORTS)
    public List<VnoEntity> getVnos() {
        CriteriaQuery<VnoEntity> query = em.getCriteriaBuilder().createQuery(VnoEntity.class);
        return em.createQuery(query.select(query.from(VnoEntity.class))).getResultList();
    }

//    CriteriaBuilder cb = em.getCriteriaBuilder();
//    CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
//    Root<Employee> fromEmployee = query.from(Employee.class);
//    return em.createQuery(query.select(fromEmployee)).getResultList();

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public VnoEntity getVno(Integer id) {
        return em.find(VnoEntity.class, id);
    }

    @Override
    public void addVno(VnoEntity vnoEntity) {
        em.persist(vnoEntity);
        em.flush();

    }

    @Override
    public void updateVno(VnoEntity vnoEntity) {
        em.merge(vnoEntity);
    }

    @Override
    public void deleteVno(Integer id) {

        em.remove(getVno(id));
    }

}
