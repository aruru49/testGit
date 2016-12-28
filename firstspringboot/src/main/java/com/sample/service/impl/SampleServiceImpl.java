package com.sample.service.impl;

import org.springframework.stereotype.Component;

import com.sample.service.SampleService;

@Component("sampleService")
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer add(int first, int second) {
		
		System.out.println("I am in service implementation");
		return first + second;
	}

}
