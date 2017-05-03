/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.casosacad.pojos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Selection;



/**
 *
 * @author wxlter97
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int first, int pageSize) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(pageSize);
        q.setFirstResult(first);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<T> findBy(String parameter, String value){
        javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<T> c = cb.createQuery(entityClass);
        javax.persistence.criteria.Root<T> t = c.from(entityClass);
        c.select(t).where(cb.like(t.<String>get(parameter), value+"%"));
        javax.persistence.Query q = getEntityManager().createQuery(c);
        return q.getResultList();
    }

    public List<T> findByJoined(String parameter, Object value){

        javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<T> c = cb.createQuery(entityClass);
        javax.persistence.criteria.Root<T> t = c.from(entityClass);
        t.join(parameter);
        c.select(t).where(cb.equal(t.get(parameter), value));
        javax.persistence.Query q = getEntityManager().createQuery(c);
        return q.getResultList();
    }
    public List<T> findByMultiple(String parameter1, Object value1, String parameter2, Object value2){

        javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<T> c = cb.createQuery(entityClass);
        javax.persistence.criteria.Root<T> t = c.from(entityClass);
        
        List<Predicate> predicates = new ArrayList<>();
        
          predicates.add(cb.equal(t.<String>get(parameter1), value1));
          predicates.add(cb.equal(t.<String>get(parameter2), value2));
        
        
        
        c.select(t).where(predicates.toArray(new Predicate[]{}));
        javax.persistence.Query q = getEntityManager().createQuery(c);
        return q.getResultList();
    }
    
    public List<T> findDistinct(String parameter){
       
        javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<T> c = cb.createQuery(entityClass);
        javax.persistence.criteria.Root<T> t = c.from(entityClass);
        c.select((Selection<? extends T>) t.get(parameter)).distinct(true);
        
        javax.persistence.Query q = getEntityManager().createQuery(c);
        return q.getResultList();
    }
    
   
    
}

