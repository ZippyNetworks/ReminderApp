package com.journaldev.spring.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Reminder;

/**
 * <h1>Reminder DAO Implementation</h1> Includes implementation of user
 * operations like add user , update user , get phone by its id
 *
 * @author Neha Sah
 * @version 1.0
 */

@Repository
public class ReminderDAOImpl implements ReminderDAO, java.io.Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ReminderDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        sessionFactory = sf;
    }

    @Override
    public void addReminder(Reminder r) {
        final Session session = sessionFactory.getCurrentSession();
        session.persist(r);
        logger.info("Reminder saved successfully, Reminder Details=" + r);
    }

    @Override
    public void updateReminder(Reminder r) {
        final Session session = sessionFactory.getCurrentSession();
        session.update(r);
        logger.info("Reminder updated successfully, Reminder Details=" + r);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Reminder> listReminder() {
        final Session session = sessionFactory.getCurrentSession();
        final List<Reminder> ReminderList = session.createQuery("from Reminder").list();
        for (final Reminder r : ReminderList)
            logger.info("Reminder List::" + r);
        return ReminderList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Reminder> listFilteredReminder(final String status, final String duedate) {
        final Session session = sessionFactory.getCurrentSession();
        final String sql = "from Reminder where status like '" + status + "' and	duedate <= '" + duedate + "'";
        // String sql = "from Reminder where status like '" + status + "' and
        // duedate < '2008-01-01'";
        final List<Reminder> ReminderList = session.createQuery(sql).list();
        for (final Reminder r : ReminderList)
            logger.info("Reminder List::" + r);
        return ReminderList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Date> listDueDate() {
        final Session session = sessionFactory.getCurrentSession();
        final List<Date> dueDateList = session.createQuery("select distinct duedate from Reminder order by duedate")
                .list();
        for (final Date d : dueDateList)
            logger.info("Due Date List::" + d);
        return dueDateList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Reminder getReminderById(int id) {
        final Session session = sessionFactory.getCurrentSession();
        final Reminder p = (Reminder) session.get(Reminder.class, new Integer(id));
        logger.info("Reminder loaded successfully, Reminder details=" + p);
        return p;
    }

}