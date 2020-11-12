package br.com.unip.aps.util;

import br.com.unip.aps.modelo.planta.Planta;

public class ValidaLuz {
	
	public boolean validarLuz(Planta planta) {
		
		if(planta.isLuz()) {
			return true;
		} else {
			return false;
		}
		
	}

}
