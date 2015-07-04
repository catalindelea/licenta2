package ro.ase.csie.licenta.main;

import ro.ase.csie.licenta.consola.ConsolaChain;
import ro.ase.csie.licenta.util.InitConfig;

public class Main {

	public static void main(String[] args) {
		InitConfig.init();
		ConsolaChain.process();
	}

}
