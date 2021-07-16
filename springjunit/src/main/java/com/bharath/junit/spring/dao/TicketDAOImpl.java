package com.bharath.junit.spring.dao;

import org.springframework.stereotype.Component;

import com.bharath.junit.spring.dto.Ticket;

@Component
public class TicketDAOImpl implements TicketDAO {

	public int createTicket(Ticket ticket) {
		return 1;
	}

}
