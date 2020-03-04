package com.globant.mentoring.app.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;

public class CommonUtils {
	
	 public static String getServerName() {
	        String message = "";
	        try {
	            message = InetAddress.getLocalHost().getHostName();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return message;
	    }
	 
	 public static String getStackTrace(Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return sw.toString();
		}

}
