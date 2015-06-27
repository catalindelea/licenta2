package ro.ase.csie.licenta.util;

import ro.ase.csie.licenta.entity.Centralizare;

public class ParseOutput {

	public static void saveInHash(String output) {
		Long id_angajat = IDValidator.parsedValidation(output);
		if (id_angajat!=null)
			Centralizare.getInstance().adaugaPontare(id_angajat);
	}
}
