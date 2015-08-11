package com.nurecdev.cricketApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/** Class: WriteFile
 * @author Mike Deiters
 * @version 1.0
 * ITEC 2150 Spring 2015
 * Written: Feb 12, 2015
 *
 *
 * This will write the contents of an ArrayList to a text file
 *
 * Purpose is create a file and write information to it
 *
 */
public class WriteFile {

	private PrintWriter writer;

	public WriteFile() {

		this.writer = null;

	}

	/**
	 * This will write each element of an array list to a file on new lines
	 * @param str ArrayList to print to a file
	 * @param saveFile file to print to
	 * @throws FileMissingException
	 */
	public WriteFile( ArrayList< String > str, File saveFile ) throws FileMissingException {

		try {
			writer = new PrintWriter(saveFile);

			for ( int i = 0; i < str.size(); i++ ) {
				writer.println(str.get(i));
			}

			writer.close();
		}
		catch ( FileNotFoundException fnf ) {
			throw new FileMissingException("I can't find the file you are trying to save to.");
		}
	}
}
