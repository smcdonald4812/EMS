package com.cognixia.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUIInputChecker {
	private Pattern names, pay, address, email, phone;
	private SimpleDateFormat dateFormat;
	
	public GUIInputChecker() {
		this.names = Pattern.compile("[A-Za-z ]+");
		this.pay = Pattern.compile("[A-Z]{3}[0-9]");
		this.address = Pattern.compile("[0-9]+ [A-Z a-z.0-9]+, [A-Z a-z]+, [A-Z]{2} [0-9]{5}");
		this.email = Pattern.compile("[A-Za-z.0-9]+@[a-z]+.[a-z]+");
		this.phone = Pattern.compile("[0-9]{10}");
		this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	public boolean isPhone(String s) {
		Matcher temp = this.phone.matcher(s.strip());
		return temp.matches();
	}
	public String getDate(Date d) {
		return dateFormat.format(d);
	}
	public boolean isName(String s) {
		Matcher temp = this.names.matcher(s.strip());
		return temp.matches();
	}

	public boolean isPay(String s) {
		Matcher temp = this.pay.matcher(s.strip());
		return temp.matches();
	}
	
	public boolean isAddress(String s) {
		Matcher temp = this.address.matcher(s.strip());
		return temp.matches();
	}
	
	public boolean isEmail(String s) {
		Matcher temp = this.email.matcher(s.strip());
		return temp.matches();
	}
}
