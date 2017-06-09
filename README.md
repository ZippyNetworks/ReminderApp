<b> ReadMe </b>


Tools & Technology Used

•	Java – Spring Framework

•	Apache Maven 

•	MySQL Database

•	ORM – Hibernate

•	Tomcat web server

•	MySQL database

•	HTML + JSP (FrontEnd)

•	Eclipse IDE

•	Postman 


<b> Running from an IDE </b>

1)  You can run the application from Eclipse IDE, however, first you will need to import your project. Import steps will vary depending on your IDE and build system. Most IDEs can import Maven projects directly, for example Eclipse users can select Import…​ → Existing Maven Projects from the File menu.

2)  Change MySQL database configurations as per the local settings in file servlet-context.xml found in the below location
/SpringMVCHibernate 2/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml ) – Line 33 & 34

3) Create database in MYSQL db 

   CREATE DATABASE `ReminderService`
 
4) Use the dump to create tables and data <br>
    DROP TABLE IF EXISTS `Reminder`;
    CREATE TABLE `Reminder` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `name` varchar(45) DEFAULT NULL,
      `description` varchar(45) DEFAULT NULL,
      `status` varchar(45) DEFAULT NULL,
      `duedate` date DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
    /*!40101 SET character_set_client = @saved_cs_client */;
    --
    -- Dumping data for table `Reminder`
    --
    LOCK TABLES `Reminder` WRITE;
    /*!40000 ALTER TABLE `Reminder` DISABLE KEYS */;
    INSERT INTO `Reminder` VALUES (2,'Lunch','Food','NOTDONE','2000-12-31'),(3,'Breakfast','Bread butter','DONE','2009-12-31'),(4,'Haircut','salon','NOTDONE','2009-12-31'),(23,'Homework','Maths','DONE','2007-11-11'),(29,'Cook food','Vegetable ','NOTDONE','2017-11-11'),(30,'Cleaning','Floor Mat','DONE','2016-11-11');
    /*!40000 ALTER TABLE `Reminder` ENABLE KEYS */;
    UNLOCK TABLES;
    -- Dump completed on 2017-06-09  0:28:37

5) Do a Maven Build & then Run as server.

<b>URL To access the full application (Basic UI + backend)</b>
http://localhost:8080/SpringMVCHibernate/reminderApp

<b> SERVICE ENDPOINTS (tested on POSTMAN):</b><br>

<b>ADD REMINDER</b>
<br>Request:  Http POST
<br>http://localhost:8080/SpringMVCHibernate/reminder/add
<br>Parameters:
<br>name=Cook food 
<br>description=Vegetable
<br>status=DONE
<br>duedate=2017-11-11
<br>Response:  {"status":"Success"}

<b>	UPDATE REMINDER </b>
<br>Request:  Http POST
<br>http://localhost:8080/SpringMVCHibernate/reminder/update/29
<br>Parameters:
<br>name=Cook food 
<br>description=Vegetable
<br>status=DONE
<br>duedate=2017-11-11
<br>Response: {"status":"Success"}

<b> FILTER REMINDER </b>

<br> -NO FILTER SELECTED
<br>Request:  Http GET
<br>http://localhost:8080/SpringMVCHibernate/reminder/view
<br>Response: [{"duedate":"2000-12-31","name":"Lunch","description":"Food","id":2,"status":"NOTDONE"},{"duedate":"2009-12-31","name":"Breakfast","description":"Bread butter","id":3,"status":"DONE"},{"duedate":"2009-12-31","name":"Haircut","description":"salon","id":4,"status":"NOTDONE"},{"duedate":"2007-11-11","name":"Homework","description":"Maths","id":23,"status":"DONE"},{"duedate":"2017-11-11","name":"Cook food","description":"Vegetable ","id":29,"status":"NOTDONE"},{"duedate":"2016-11-11","name":"Cleaning","description":"Floor Mat","id":30,"status":"DONE"},{"duedate":"2017-05-05","name":"Book Flight","description":"India","id":31,"status":"DONE"}]

<br>-BY STATUS
<br>Request:  Http GET
<br>http://localhost:8080/SpringMVCHibernate/reminder/view?status=NOTDONE
<br>Response: [{"duedate":"2000-12-31","name":"Lunch","description":"Food","id":2,"status":"NOTDONE"},{"duedate":"2009-12-31","name":"Haircut","description":"salon","id":4,"status":"NOTDONE"}]

<br>-BY DUEDATE – Will show all the reminder on & before the selected date
<br>Request:  Http GET
<br>http://localhost:8080/SpringMVCHibernate/reminder/view?duedate=2010-11-11
<br>Response: [{"duedate":"2000-12-31","name":"Lunch","description":"Food","id":2,"status":"NOTDONE"},{"duedate":"2009-12-31","name":"Breakfast","description":"Bread butter","id":3,"status":"DONE"},{"duedate":"2009-12-31","name":"Haircut","description":"salon","id":4,"status":"NOTDONE"},{"duedate":"2007-11-11","name":"Homework","description":"Food","id":23,"status":"DONE"}]

<br>BY DUEDATE & STATUS : 
<br>Request:  Http GET
<br>http://localhost:8080/SpringMVCHibernate/reminder/view?duedate=2010-11-11&status=DONE
<br>Response: 
[{"duedate":"2009-12-31","name":"Breakfast","description":"Bread butter","id":3,"status":"DONE"},{"duedate":"2007-11-11","name":"Homework","description":"Food","id":23,"status":"DONE"}]
















