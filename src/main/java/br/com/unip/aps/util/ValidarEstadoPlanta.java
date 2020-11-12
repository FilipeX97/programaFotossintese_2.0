package br.com.unip.aps.util;

import br.com.unip.aps.modelo.planta.Planta;

public class ValidarEstadoPlanta {
	
	public boolean validar(Planta planta) {
		
		if(planta.isEstadoPlanta() == true && planta.isColherPlanta() == false) {
			return true;
		} else {
			System.out.println("Planta está morta ou já foi colhida");
			return false;
		}
		
	}

}
