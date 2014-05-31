package com.bestpractice.junit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bestpractice.junit.domain.Customer;
import com.bestpractice.junit.domain.Representative;

public class CustomerTest {

	Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer(1, "Jesus");
	}

	@After
	public void tearDown() {
		customer = null;
	}

	@Test
	public void testSetAddress() {
		customer.setAddress("Boodschapstraat", 15, "Bollebergen");
		assertEquals("Boodschapstraat 15, Bollebergen.", customer.getAddress());
	}

	@Test
	public void testSetDateOfBirth() {
		customer.setDateOfBirth(new GregorianCalendar(1992, 11, 02));
		assertEquals(20, customer.getAge());
	}

	@Test
	public void testSetID() {
		customer.setID(5);
		assertEquals(5, customer.getId());
	}

	@Test
	public void testGoodCustomer() {
		customer.setGoodCustomer(true);
		assertTrue(customer.isGoodCustomer());
	}

	@Test
	public void testBadCustomer() {
		customer.setGoodCustomer(false);
		assertFalse(customer.isGoodCustomer());
	}

	@Test
	public void testHasRepresentative() {
		customer.setRepresentative(new Representative(1, "Lewis"));
		assertNotNull(customer.getRepresentative());
	}

	@Test
	public void testHasNoRepresentative() {
		assertNull(customer.getRepresentative());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetIDNegative() {
		customer.setID(-5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetIDZero() {
		customer.setID(0);
	}
}
