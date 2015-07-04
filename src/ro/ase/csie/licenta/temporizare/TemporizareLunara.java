package ro.ase.csie.licenta.temporizare;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import ro.ase.csie.licenta.raport.RaportAngajat;

public class TemporizareLunara extends TimerTask {

	private final static long PE_ZI = 1000 * 60 * 60 * 24;

	@Override
	public void run() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if (calendar.get(Calendar.DAY_OF_MONTH)==0){
			verificaLunaTrecutaAngajati();
		}
	}

	private static Date getMaine() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	public static void startTemporizareLunara() {
		TemporizareZilnica task = new TemporizareZilnica();
		Timer timer = new Timer();
		timer.schedule(task, getMaine(), PE_ZI);
	}

	public void verificaLunaTrecutaAngajati() {
		RaportAngajat.verificaLunaTrecutaAngajati();
	}

}
