package com.sample.service.impl;

import org.junit.Assert;
import org.junit.Test;


public class SampleServiceImplTest {

	@Test
	public void testAdd() {

		SampleServiceImpl service = new SampleServiceImpl();
		
		int result = service.add(200, 300);
		
		Assert.assertEquals(500, result);
		
	}

}
