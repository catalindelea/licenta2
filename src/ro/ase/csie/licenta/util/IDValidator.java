package ro.ase.csie.licenta.util;

import org.apache.log4j.Logger;

public class IDValidator {
	
	private static Logger logger = Logger.getLogger(IDValidator.class);
	
	public static Long parsedValidation(String output) {
		boolean result=true;
		if (output.length()!=8) result = false;
		try {
			Integer.parseInt(output);
		} catch (Exception e) {
			result = false;
			logger.error(e);
			e.printStackTrace();
		}
		if (result) return Long.parseLong(output); 
		else return null;
	}
}
