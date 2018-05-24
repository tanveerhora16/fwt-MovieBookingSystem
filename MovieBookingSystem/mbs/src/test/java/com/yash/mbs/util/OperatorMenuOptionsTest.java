package com.yash.mbs.util;

import org.junit.Test;

import com.yash.mbs.exception.EmptyException;
import com.yash.mbs.exception.FilePathIsNullException;

public class OperatorMenuOptionsTest {

	@Test(expected = FilePathIsNullException.class)
	public void getOperatorMenuOptions_shouldThrowFileNameIsNullException_when_filePathIsNull() {
		String filepath = null;
		OperatorMenuOptions.getOperatorMenuOptions(filepath);

	}

	
	@Test(expected = EmptyException.class)
	public void getMenu_shouldThrowEmptyException_whenFileLocationIsEmpty() {
		OperatorMenuOptions.getOperatorMenuOptions("");
	}
	
	
	@Test
	public void getOperatorMenuOptions_shouldThrowEmptyException_whenFileIsEmpty() {
		String filepath = "/src/main/resources/file/OperatorMenuFile.txt";
		OperatorMenuOptions.getOperatorMenuOptions(filepath);

	}
	
	

}
