package com.journaldev.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ReminderDAO;
import com.journaldev.spring.model.Reminder;

@Service
public class ReminderServiceImpl implements ReminderService {

	private ReminderDAO reminderDAO;

	public void setReminderDAO(ReminderDAO reminderDAO) {
		this.reminderDAO = reminderDAO;
	}

	@Override
	@Transactional
	public void addReminder(Reminder r) {
		this.reminderDAO.addReminder(r);
	}

	@Override
	@Transactional
	public void updateReminder(Reminder r) {
		this.reminderDAO.updateReminder(r);
	}

	@Override
	@Transactional
	public List<Reminder> listReminder() {
		return this.reminderDAO.listReminder();
	}

	@Override
	@Transactional
	public List<Reminder> listFilteredReminder(String s, String d) {
		return this.reminderDAO.listFilteredReminder(s, d);
	}

	@Override
	@Transactional
	public Reminder getReminderById(int id) {
		return this.reminderDAO.getReminderById(id);
	}

	@Override
	@Transactional
	public List<Date> listDueDate() {
		return this.reminderDAO.listDueDate();
	}
}
