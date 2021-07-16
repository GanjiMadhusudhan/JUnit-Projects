package com.bharath.junit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharath.junit.spring.dao.TicketDAO;
import com.bharath.junit.spring.dto.Ticket;

@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO dao;

	@Override
	public int buyTicket(String passengerName, String phone) {
		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		return getDao().createTicket(ticket);
	}

	public TicketDAO getDao() {
		return dao;
	}

	public void setDao(TicketDAO dao) {
		this.dao = dao;
	}

}
