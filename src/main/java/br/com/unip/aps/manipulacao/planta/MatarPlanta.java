package br.com.unip.aps.manipulacao.planta;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.util.ValidarEstadoPlanta;

public class MatarPlanta {
	
	private static final Logger logger = Logger.getLogger(MatarPlanta.class);
	
	public void matarPlanta(Planta planta) {

		ValidarEstadoPlanta validaPlanta = new ValidarEstadoPlanta();

		if (validaPlanta.validar(planta)) {
			planta.setEstadoPlanta(false);
			System.out.println("Planta morta!");
			logger.info("Planta morta!");
		}

	}

}
