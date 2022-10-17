package com.hendisantika.entity;

import java.util.Date;

/**
 * 
 */

public class Person extends AbstractModel<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = 495598567035857667L;
	
	
	public enum TypePerson{ACTEUR, REALISATEUR}
	
	private String firstname;
	
	private String lastname;
	
	private String photo;
	
	private Date birthDay;
	
	private Date createdAt;
	
	private Nationality nationality;
	
}
