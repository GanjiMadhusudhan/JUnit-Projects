package com.bharath.junit.spring.dao;

import org.springframework.stereotype.Component;

import com.bharath.junit.spring.dto.Ticket;

@Component
public class TicketDAOImpl implements TicketDAO {

	public int createTicket(Ticket ticket) {
		System.out.println("Inside class: "+this.getClass().getSimpleName()+".  Inside method: createTicket()");
		return 1;
	}

}
