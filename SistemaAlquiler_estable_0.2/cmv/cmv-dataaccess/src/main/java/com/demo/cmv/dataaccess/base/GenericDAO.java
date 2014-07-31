package com.demo.cmv.dataaccess.base;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

public interface GenericDAO <T,ID extends Serializable> {

    public Class<T> getPersistentClass();    

    public List executeQuery(final String queryString, int firstResult, int maxResults);

    public List executeQuery(final String queryString, final String[] named, final Object[] values, int firstResult, int maxResults);

    public List<T> executeQuery(final String queryString);

    public List<T> executeSQLQuery(final String queryString);

    public List<T> listByCriteria(DetachedCriteria c);

    public List<T> listByCriteria(DetachedCriteria c,int firstResult,int maxResult);

    public List<T> findbyCriterion(final Criterion... criterions);

    public List<T> findbyNamedParam(final String query, final String[] named, final Object[]  values);

    public List<T> findbyNamedOneParam(final String query, final String named, final Object values);

    public T get(final ID id);

    @Transactional
    public ID insert(final T entity);

    @Transactional
    public T merge(final T entity);

    @Transactional
    public void delete(final T entity);

    @Transactional
    public void saveOrUpdate(final T entity);

    @Transactional
    public void update(final T entity);

    public List<T> getAll();

    @Transactional
    public int deleteById(final ID id);
    
    public List<T> executeSimpleSQLQuery(final String queryString);
}