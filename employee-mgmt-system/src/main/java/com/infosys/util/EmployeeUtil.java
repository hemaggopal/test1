package com.infosys.util;

import java.text.MessageFormat;

public class EmployeeUtil {

	public static String formatMsg(String msg, Object... value) {
		//System.out.println(msg + ": va: " + value);
		return MessageFormat.format(msg, value);
	}
}
