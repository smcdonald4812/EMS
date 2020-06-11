package com.cognixia.util;

import java.awt.TextField;

public class ButtonsUtil {
	public void clear(TextField... args) {
		for (TextField textField : args) {
			textField.setText("");
		}
	}
}
