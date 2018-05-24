package com.yash.mbs.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.yash.mbs.exception.EmptyException;
import com.yash.mbs.exception.FilePathIsNullException;

public class OperatorMenuOptions {

	public static void getOperatorMenuOptions(String filepath) {
		if (filepath == null)
			throw new FilePathIsNullException("File Path Can Not Be Null");

		if (filepath.isEmpty())
			throw new EmptyException("File Path cannot be empty");

		File operatorMenuFile = new File(OperatorMenuOptions.class.getResource("/file/OperatorMenuFile.txt").getFile());

		try {
			FileInputStream fis = new FileInputStream(operatorMenuFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

			System.out.println("Reading File line by line using BufferedReader");

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}

		} catch (IOException ex) {
			Logger.getLogger(OperatorMenuOptions.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
