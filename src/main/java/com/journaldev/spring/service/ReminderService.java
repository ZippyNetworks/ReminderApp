package com.journaldev.spring.service;

import java.util.Date;
import java.util.List;

import com.journaldev.spring.model.Reminder;

public interface ReminderService {

	public void addReminder(Reminder r);

	public void updateReminder(Reminder r);

	public Reminder getReminderById(int id);

	public List<Reminder> listReminder();

	public List<Reminder> listFilteredReminder(String s, String d);

	public List<Date> listDueDate();

}
