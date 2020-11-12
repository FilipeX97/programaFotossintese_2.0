package br.com.unip.aps.manipulacao.planta;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.util.ValidarEstadoPlanta;

public class ColherPlanta {
	
	private static final Logger logger = Logger.getLogger(ColherPlanta.class);
	
	public void colherPlanta(Planta planta) {
		ValidarEstadoPlanta estadoPlanta = new ValidarEstadoPlanta();
		if(estadoPlanta.validar(planta)) {
			if(planta.getQuantidadeDeEnergiaNaPlanta() == planta.getQuantidadeEnergiaParaColherPlanta()
					&& planta.getEstagioAtualPlanta() == planta.getEstagioFinalPlanta()) {
				planta.setColherPlanta(true);
				System.out.println("Planta colhida parabéns por ter cuidado dela até aqui.");
				logger.info("Planta colhida parabéns por ter cuidado dela até aqui.");
			}
			else {
				System.out.println("Ainda não é possível colher a planta!");
				logger.info("Ainda não é possível colher a planta!");
			}
		}
	}

}
