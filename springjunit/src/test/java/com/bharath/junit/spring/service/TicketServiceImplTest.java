package com.bharath.junit.spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.ArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.Mockito.when;

import com.bharath.junit.spring.dao.TicketDAO;
import com.bharath.junit.spring.dto.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final String PHONE_NUMBER = "1234567890";
	private static final String PASSANGER_NAME = "Thor";
	private static final int RESULT = 1;
	
	@Mock
	TicketDAO dao;
	
	@InjectMocks
	@Autowired
	private TicketServiceImpl service;
	
	@Mock
	Ticket ticket;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShouldReturnValidTicket() {
		when(dao.createTicket(ticket)).thenReturn(1);
		int result = service.buyTicket(PASSANGER_NAME, PHONE_NUMBER);
		assertEquals(RESULT, result);
	}

	

}
