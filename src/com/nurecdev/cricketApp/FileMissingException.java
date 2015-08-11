package com.nureech.cricketApp;


/** Class: FileMissingException
 * @author Mike Deiters
 * @version 1.0
 * ITEC 2150 Spring 2015
 * Written: Feb 14, 2015
 *
 *
 * This will accept an error message to display to the user
 *
 * Purpose is create a new exception that will be thrown instead of FileNotFoundException
 *
 */
public class FileMissingException extends RuntimeException {

	public FileMissingException() {

		super();
	}

	/**
	 * @param arg0
	 */
	public FileMissingException( String arg0 ) {

		super(arg0);
	}

}
