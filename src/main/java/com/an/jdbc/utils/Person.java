package com.an.jdbc.utils;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Person {
	
	private int pk;
	private String id;
	private String pass;

}
