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
		System.out.println("Inside class: "+this.getClass().getSimpleName()+".  Inside method: buyTicket()");
		return getDao().createTicket(ticket);
	}

	public TicketDAO getDao() {
		System.out.println("Inside class: "+this.getClass().getSimpleName()+".  Inside method: getDao()");
		return dao;
	}

	public void setDao(TicketDAO dao) {
		System.out.println("Inside class: "+this.getClass().getSimpleName()+".  Inside method: setDao()");
		this.dao = dao;
	}

}
