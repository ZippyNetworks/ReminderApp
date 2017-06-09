package com.journaldev.spring.PhoneControllerTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
//import org.springframework
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PhoneDAO;
import com.journaldev.spring.model.Phone;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-servlet-test.xml")
@WebAppConfiguration
public class PhoneControllerTest {

	@Autowired
	//private phoneDAO phoneDAO;
	private PhoneDAO phoneDAO ;

	@Test
	@Transactional
	@Rollback(true)
	public void getPhone() throws Exception {
		Phone phone = phoneDAO.getPhoneById(10);
		Assert.assertEquals(10, phone.getId());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void updatePhone() throws Exception {
		Phone beforePhoneUpdate = phoneDAO.getPhoneById(12);
		beforePhoneUpdate.setDescription("Description Updated");

		phoneDAO.updatePhone(beforePhoneUpdate);
		Phone afterPhoneUpdate = phoneDAO.getPhoneById(12);
		Assert.assertEquals(beforePhoneUpdate, afterPhoneUpdate);
	}
	

	@Test
	@Transactional
	@Rollback(true)
	public void deletePhone() throws Exception {
		
		boolean deleted = false;
		//deleted = phoneDAO.deletePhone(phone);
		phoneDAO.removePhone(24);
		Phone phone = phoneDAO.getPhoneById(24);
		
		Assert.assertEquals(phone, null);
	}
}