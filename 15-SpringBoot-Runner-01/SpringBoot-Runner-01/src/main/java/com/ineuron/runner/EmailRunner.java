package com.ineuron.runner;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class EmailRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("From ApplicationRunner :: "+Arrays.asList(args.getSourceArgs()));

	}

}
