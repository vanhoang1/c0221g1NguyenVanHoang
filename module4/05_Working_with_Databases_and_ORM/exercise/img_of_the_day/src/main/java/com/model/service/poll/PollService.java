package com.model.service.poll;

import com.model.bean.Poll;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
@Service
public class PollService implements IPollService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Poll> findAll() {
        String queryStr = "SELECT p FROM Poll AS p";
        TypedQuery<Poll> query = entityManager.createQuery(queryStr, Poll.class);
        return query.getResultList();
    }

    @Override
    public Poll findOne(Long id) {
        String queryStr = "SELECT p FROM Poll AS p WHERE p.id = :id";
        TypedQuery<Poll> query = entityManager.createQuery(queryStr, Poll.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Poll> findAllOnCurrentDate() {
        String queryStr = "SELECT p FROM Poll AS p WHERE p.dateCreate = :date";
        TypedQuery<Poll> query = entityManager.createQuery(queryStr, Poll.class);
        query.setParameter("date", LocalDate.now());
        return query.getResultList();
    }

    @Override
    public Poll save(Poll poll) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Poll origin = findOne(poll.getId());
            origin.setAuthor(poll.getAuthor());
            origin.setEvaluate(poll.getEvaluate());
            origin.setFeedback(poll.getFeedback());
            origin.setDateCreate(poll.getDateCreate());
            origin.setCountLike(poll.getCountLike());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Poll> save(List<Poll> polls) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Poll> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Poll poll) {

    }

    @Override
    public void delete(List<Poll> customers) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Poll add(Poll poll) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(poll);
            transaction.commit();
            return  poll;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void like(long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Poll origin = findOne(id);
            origin.setCountLike(origin.getCountLike()+1);
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
