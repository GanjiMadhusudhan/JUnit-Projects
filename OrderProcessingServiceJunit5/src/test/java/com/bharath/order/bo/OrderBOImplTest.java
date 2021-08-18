package com.bharath.order.bo;

import static org.junit.Assert.assertFalse;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bharath.order.bo.exception.BOException;
import com.bharath.order.dao.FinalProduct;
import com.bharath.order.dao.OrderDAOImpl;
import com.bharath.order.dao.Product;
import com.bharath.order.dto.Order;

public class OrderBOImplTest {

	private static final int ORDER_ID = 123;
	@Mock
	OrderDAOImpl dao;
	private OrderBOImpl bo;
	
	@Mock
	Product product;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);		
		bo = new OrderBOImpl();
		bo.setDao(dao);
		bo.setProduct(product);
	}

	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao, atLeast(1)).create(order);

	}

	@Test
	public void placeOrder_Should_not_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		// when(dao.create(order)).thenReturn(new Integer(0));
		boolean result = bo.placeOrder(order);

		assertFalse(result);
		verify(dao).create(order);

	}

	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(any(Order.class))).thenThrow(SQLException.class);
		boolean result = bo.placeOrder(order);

	}

	@Test
	public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(anyInt())).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result = bo.cancelOrder(123);
		assertTrue(result);

		verify(dao).read(anyInt());
		verify(dao).update(order);

	}

	@Test
	public void cancelOrder_Should_NOT_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		boolean result = bo.cancelOrder(123);

		assertFalse(result);

		verify(dao).read(ORDER_ID);
		verify(dao).update(order);

	}

	@Test(expected = BOException.class)
	public void cancelOrder_ShouldThrowABOExceptionOnRead() throws SQLException, BOException {
		when(dao.read(anyInt())).thenThrow(SQLException.class);
		bo.cancelOrder(ORDER_ID);

	}

	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_A_BOExceptionOnUpdate() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		bo.cancelOrder(ORDER_ID);

	}

	@Test
	public void getProductId() throws SQLException, BOException {

		when(product.getId()).thenReturn(new Integer(1));
		Integer result = bo.getProductId();
		assertEquals(new Integer(1),result);
	}
}
