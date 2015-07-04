package ro.ase.csie.licenta.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class InitConfig {
	public static void init(){
		try {
		File file = new File("config.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
			while ((linie = reader.readLine()) != null) {
				if (linie.startsWith("#"))
					continue;
				if (linie.startsWith("ip")) {
					String[] componente = linie.split(" ");
					ConstantParams.HOST="tcp://"+componente[1];
				}
				if (linie.startsWith("port")) {
					String[] componente = linie.split(" ");
					ConstantParams.PORT=componente[1];
				}
				break;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
