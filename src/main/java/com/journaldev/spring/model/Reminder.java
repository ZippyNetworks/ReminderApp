package com.journaldev.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 *
 * @author neha
 *
 */
@Entity
@Table(name = "Reminder")
public class Reminder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;

    private String Description;

    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date duedate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String desc) {
        Description = desc;
    }

    public String getstatus() {
        return status;
    }

    public String setstatus(String status) {
        return this.status = status;
    }

    public Date getduedate() {
        return duedate;
    }

    public void setduedate(Date date) {

        duedate = date;
    }

    /*
     * public void setduedate(String date) throws ParseException {
     * 
     * this.duedate = new SimpleDateFormat("yyyy-MM-dd").parse(date); }
     */

    // @Override
    // public String toString(){
    // return "id="+id+", name="+firstName+", lastName="+lastName +", address= "
    // + address; //+ ",phones " + phones.get(0);
    // }
}
