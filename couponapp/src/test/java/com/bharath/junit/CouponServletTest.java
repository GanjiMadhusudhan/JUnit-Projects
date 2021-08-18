package com.bharath.junit;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@RunWith(MockitoJUnitRunner.class)
public class CouponServletTest {
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpServletResponse response;
	
	@Mock
	RequestDispatcher requestDispatcher;
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(printWriter);
		new CouponServlet().doGet(request, response);
		assertEquals("SUPERSALE",stringWriter.toString());
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		when(request.getParameter("coupon")).thenReturn("SUPERSALE");
		when(request.getRequestDispatcher("response.jsp")).thenReturn(requestDispatcher);
		new CouponServlet().doPost(request, response);
		verify(request).setAttribute("discount",  "Discount for coupon SUPERSALE is 50%");
		verify(requestDispatcher).forward(request, response);
	}

}
