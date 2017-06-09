package com.journaldev.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.model.Reminder;
import com.journaldev.spring.service.ReminderService;

@Controller(value = "Reminder")
public class ReminderController {

    private ReminderService reminderService;
    private static final Logger logger = LoggerFactory.getLogger(ReminderController.class);

    @Autowired(required = true)
    @Qualifier(value = "reminderService")
    public void setReminderService(ReminderService rs) {
        reminderService = rs;
    }

    @RequestMapping(value = "/reminderApp", method = RequestMethod.GET)
    public ModelAndView listReminder(Model model,
            @RequestParam(value = "status", defaultValue = "%") String statusSelected,
            @RequestParam(value = "duedate", defaultValue = "2050-04-04") String duedateSelected) {
        System.out.println("statusSelected**** " + statusSelected + "  duedateSelected****" + duedateSelected);
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        final List<Reminder> listRem = reminderService.listFilteredReminder(statusSelected, duedateSelected);
        model.addAttribute("listReminder", listRem);
        model.addAttribute("listDueDate", reminderService.listDueDate());
        model.addAttribute("Selectlist", statusSelected);
        model.addAttribute("Datelist", duedateSelected);
        return new ModelAndView("MainPage");

    }

    @RequestMapping(value = "/addNewReminder")
    public String AddReminder(Model model) {
        model.addAttribute("reminder", new Reminder());
        // model.addAttribute("listReminder",
        // this.reminderService.listReminder());
        return "NewReminder";
    }

    @RequestMapping(value = "/reminder/view", method = RequestMethod.GET)
    public @ResponseBody JSONArray viewReminder(
            @RequestParam(value = "status", defaultValue = "%") String statusSelected,
            @RequestParam(value = "duedate", defaultValue = "2050-04-04") String duedateSelected) {
        final JSONArray filteredReminder = new JSONArray();
        final List<Reminder> listRem = reminderService.listFilteredReminder(statusSelected, duedateSelected);
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (final Reminder r : listRem) {
            final JSONObject obj = new JSONObject();
            obj.put("id", r.getId());
            obj.put("name", r.getName());
            obj.put("description", r.getDescription());
            final String reportDate = df.format(r.getduedate());
            obj.put("duedate", reportDate);
            obj.put("status", r.getstatus());
            filteredReminder.add(obj);
        }
        return filteredReminder;
    }

    @RequestMapping(value = "/reminder/add", method = RequestMethod.POST)
    public @ResponseBody JSONObject addReminder(@ModelAttribute("reminder") Reminder r) {
        final JSONObject responseObj = new JSONObject();
        try {
            reminderService.addReminder(r);
            responseObj.put("status", "Success");
        } catch (final Exception ex) {
            responseObj.put("status", "Failure");
        }
        return responseObj;
    }

    @RequestMapping(value = "/reminder/update/{id}", method = RequestMethod.POST)
    public @ResponseBody JSONObject updateReminder(@ModelAttribute("reminder") Reminder r, @PathVariable("id") int id) {
        final JSONObject responseObj = new JSONObject();
        try {
            r.setId(id);
            reminderService.updateReminder(r);
            responseObj.put("status", "Success");
        } catch (final Exception ex) {
            responseObj.put("status", "Failure");
        }
        return responseObj;
    }

    @RequestMapping(value = "/updateReminder/{id}")
    public String updateReminder(Model model, @PathVariable("id") int id) {
        final Reminder p = reminderService.getReminderById(id);
        model.addAttribute("reminder", p);
        return "UpdateReminder";
    }
}
