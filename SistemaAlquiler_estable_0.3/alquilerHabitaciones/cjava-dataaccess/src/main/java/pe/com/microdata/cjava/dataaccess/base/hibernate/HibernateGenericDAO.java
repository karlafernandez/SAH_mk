package pe.com.microdata.cjava.dataaccess.base.hibernate;

import pe.com.microdata.cjava.dataaccess.base.GenericDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 

public class HibernateGenericDAO<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID> {

    private Class<T> persistentClass;

    public HibernateGenericDAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void delete(final T entity) {
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.delete(entity);
                return null;
            }
        });
    }

    @Override
    public List executeQuery(final String queryString, final int firstResult, final int maxResults) {

        return getHibernateTemplate().executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery(queryString);
                query.setFirstResult(firstResult);
                query.setMaxResults(maxResults);

                List list = query.list();
                return list;
            }
        });
    }

    @Override
    public List executeQuery(final String queryString, final String[] named, final Object[] values,
            final int firstResult, final int maxResults) {

        return getHibernateTemplate().executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery(queryString);
                query.setFirstResult(firstResult);
                query.setMaxResults(maxResults);
                for (int c = 0; c < named.length; c++) {
                    query.setParameter(named[c], values[c]);
                }

                List list = query.list();
                return list;
            }
        });
    }

    @Override
    public List<T> executeQuery(final String queryString) {

        return getHibernateTemplate().executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery(queryString);
                List list = query.list();
                return list;
            }
        });
    }

    @Override
    public List<T> executeSQLQuery(final String queryString) {

        return getHibernateTemplate().executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery query = session.createSQLQuery(queryString);
                query.addEntity(persistentClass);
                List list = query.list();
                return list;
            }
        });
    }

    @Override
    public List<T> executeSimpleSQLQuery(final String queryString) {
        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery query = session.createSQLQuery(queryString);

                List list = query.list();
                return list;
            }
        });
    }

    @Override
    public List<T> findbyCriterion(final Criterion... criterions) {

        return getHibernateTemplate().executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {

                Criteria criteria = session.createCriteria(getPersistentClass());
                criteria.add(Restrictions.disjunction());
                for (Criterion criterion : criterions) {
                    criteria.add(criterion);
                }
                List result = criteria.list();
                return result;
            }
        });
    }

    @Override
    public List<T> findbyNamedParam(final String query, final String[] named, final Object[] values) {

        return getHibernateTemplate().executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                List list = getHibernateTemplate().findByNamedParam(query, named, values);
                return list;
            }
        });
    }

    @Override
    public List<T> findbyNamedOneParam(final String query, final String named, final Object values) {

        return getHibernateTemplate().executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                List list = getHibernateTemplate().findByNamedParam(query, named, values);
                return list;
            }
        });
    }

    @Override
    public T get(final ID id) {

        return (T) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Object obj = session.get(persistentClass, id);
                return obj;
            }
        });
    }

    @Override
    public ID insert(final T entity) {

        return (ID) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Serializable id = session.save(entity);
                return id;
            }
        });
    }

    @Override
    public T merge(final T entity) {

        return (T) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.setFlushMode(FlushMode.AUTO);
                return session.merge(entity);
            }
        });
    }
    //@Transactional

    @Override
    public void saveOrUpdate(final T entity) {
        final Transaction transaction = null;

        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.saveOrUpdate(entity);
                ///session.flush();
                ///session.close();
                return null;
            }
        });
    }

    @Override
    public void update(final T entity) {

        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.update(entity);
                return null;
            }
        });
    }

    @Override
    public List<T> getAll() {
        return findbyCriterion();
    }

    @Override
    public int deleteById(final ID id) {
        return (Integer) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {

                int affectedRecords = session.createQuery(
                        "delete from " + getPersistentClass().getSimpleName() + " where id = ?").setParameter(0, id).executeUpdate();
                return affectedRecords;
            }
        });

    }

    @Override
    public List<T> listByCriteria(DetachedCriteria c) {
        return getHibernateTemplate().findByCriteria(c);
    }

    @Override
    public List<T> listByCriteria(DetachedCriteria c, int firstResult, int maxResult) {
        return getHibernateTemplate().findByCriteria(c, firstResult, maxResult);
    }
}