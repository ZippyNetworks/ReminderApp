package com.journaldev.spring.dao;

import java.util.Date;
import java.util.List;

import com.journaldev.spring.model.Reminder;

/**
 * <h1>ReminderDAO</h1> Includes user operations like add user , update user ,
 * get phone by its id etc
 *
 * @author Neha Sah
 * @version 1.0
 *
 */

public interface ReminderDAO {

    public void addReminder(Reminder r);

    public void updateReminder(Reminder r);

    public Reminder getReminderById(int id);

    public List<Reminder> listReminder();

    public List<Reminder> listFilteredReminder(String s, String d);

    public List<Date> listDueDate();

}
