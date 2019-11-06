package com.freesky.entity;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class PersonTest {
	
	private Person person = new Person();
	
	private final String name = "Max";
	
	@Before
	public void init() {
		person.setName(name);
	}
	
	@Test
	public void testGetName() {
		Assert.assertEquals(person.getName(), name);
	}

}
