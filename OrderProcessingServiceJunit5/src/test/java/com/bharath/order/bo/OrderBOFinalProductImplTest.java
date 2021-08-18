package com.bharath.order.bo;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bharath.order.bo.OrderBOImpl;
import com.bharath.order.bo.exception.BOException;
import com.bharath.order.dao.FinalProduct;
import com.bharath.order.dao.OrderDAOImpl;
import com.bharath.order.dao.Product;
import com.bharath.order.dto.Order;

public class OrderBOFinalProductImplTest {

	private static final int ORDER_ID = 123;
	
	@Mock
	OrderDAOImpl dao;
	
	@Mock
	Order order;
	
	private OrderBOImpl bo;
	
	FinalProduct fpObject = new FinalProduct();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);		
		bo = new OrderBOImpl();		
		bo.setDao(dao);
		bo.setFinalProduct(fpObject);
	}

	@Test
	public void finalProductObject() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao, atLeast(1)).create(order);

	}
	
	@Test
	public void finalProductObjectEx2() throws SQLException, BOException {

		
		when(dao.create(order)).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao, atLeast(1)).create(order);

	}
}
