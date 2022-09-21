package com.attendancesys.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validators {

	
	public static boolean isValidEmail(String email) {
	    String email_pattern = "^[a-zA-Z0-9_#$%&’+/=?^.-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    Pattern pattern = Pattern.compile(email_pattern);
	    Matcher match = pattern.matcher(email);
	    return match.matches();
	}
}
