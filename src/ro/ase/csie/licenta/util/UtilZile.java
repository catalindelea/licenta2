package ro.ase.csie.licenta.util;

import java.util.Calendar;
import java.util.Date;

public class UtilZile {
	public static Date getIeri(){
	     return new Date(System.currentTimeMillis()-24*60*60*1000);
	}
	
	public static Date midnight(Date data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        System.out.println(calendar.getTime());
        return calendar.getTime();
	}
	
	public static Date tMidnight(Date data){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        System.out.println(calendar.getTime());
        return calendar.getTime();
	}
	
	public static float fromMilisToFloatHm(Long millis) {
		StringBuilder Hm =new StringBuilder();
		int hours   = (int) ((millis / (1000*60*60)) % 24);
		Hm.append(hours);
		millis -= hours*1000*60*60;
		int minutes = (int) ((millis / (1000*60)) % 60);
		int percentageMinutes = (minutes*100)/60;
		Hm.append("."+percentageMinutes);
		return Float.parseFloat(Hm.toString());
	}
}
