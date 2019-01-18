package com.example.demo.model;

import org.apache.log4j.Logger;

public class Student {
	public static final Logger LOGGER = Logger.getLogger(Student.class);

	static int number=5;
	public static void main(String[] args) {
		LOGGER.info("testing Info method..."+number+1);
		LOGGER.debug("Testing of debug method.. is correct.");
	}

}
