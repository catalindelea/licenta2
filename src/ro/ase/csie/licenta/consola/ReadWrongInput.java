package ro.ase.csie.licenta.consola;

public class ReadWrongInput implements Input{

	@Override
	public boolean accepta(String comandaData) {
		if (comandaData.equalsIgnoreCase("asculta") ||
				comandaData.equalsIgnoreCase("salveaza") ||
				comandaData.equalsIgnoreCase("sincronizeaza")) {
			return true;
		} else 
		System.out.println("Alegeti intre: 'asculta', 'salveaza' si 'sincronizeaza'");
        return true;
	}

	@Override
	public void executa() {
	}

}
