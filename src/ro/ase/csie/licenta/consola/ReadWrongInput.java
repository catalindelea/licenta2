package ro.ase.csie.licenta.consola;

public class ReadWrongInput implements Input{

	@Override
	public boolean accepta(String comandaData) {
		System.out.println("Alegeti intre: 'asculta', 'salveaza' si 'sincronizeaza'");
        return true;
	}

	@Override
	public void executa() {
	}

}
