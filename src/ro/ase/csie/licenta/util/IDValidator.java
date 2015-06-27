package ro.ase.csie.licenta.util;

public class IDValidator {
	public static Long isValid(String output) {
		boolean result=true;
		if (output.length()!=8) result = false;
		try {
			Integer.parseInt(output);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		if (result) return Long.parseLong(output); 
		else return null;
	}
}
