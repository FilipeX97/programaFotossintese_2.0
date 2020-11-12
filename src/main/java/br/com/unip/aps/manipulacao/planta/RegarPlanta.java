package br.com.unip.aps.manipulacao.planta;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.Pessoa;
import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.util.ValidaLuz;
import br.com.unip.aps.util.ValidarEstadoPlanta;

public class RegarPlanta {
	
	private static final Logger logger = Logger.getLogger(RegarPlanta.class);
	ValidarEstadoPlanta validaPlanta = new ValidarEstadoPlanta();
	ValidaLuz validaLuz = new ValidaLuz();
	
	public void regarPlanta(Pessoa pessoa, Planta planta) {
		if(validaPlanta.validar(planta) && validaLuz.validarLuz(planta)) {
			if (planta.getQuantidadeDeEnergiaNaPlanta() < planta.getQuantidadeEnergiaParaColherPlanta()) {
				
				if(pessoa.getQuatidadeRegaPlanta() < 3) {
					pessoa.regar();
					planta.setQuantidadeDeAguaDuranteDia(pessoa.getQuatidadeRegaPlanta());
					System.out.println("Planta Regada");
					logger.info("Planta Regada");
					
					if(planta.getQuantidadeDeAguaDuranteDia() < planta.getQuantidadeDeAguaTotalDoDia()) {
						System.out.println(pessoa.getNomePessoa() 
								+ ", ainda falta regar " 
								+ (planta.getQuantidadeDeAguaTotalDoDia() - planta.getQuantidadeDeAguaDuranteDia()) 
								+ " vez(es) durante o dia.");
						
						logger.info("Usu�rio tentou colher a planta sem estar no estado adequado!");
						logger.info("\n"+
							pessoa.getNomePessoa() 
							+ ", ainda falta regar " 
							+ (planta.getQuantidadeDeAguaTotalDoDia() - planta.getQuantidadeDeAguaDuranteDia()) 
							+ " vez(es) durante o dia.");
					} else {
						System.out.println("J� foi atingida a quantidade m�xima que pode regar a planta, poder� regar somente no dia seguinte, ap�s dormir");
						logger.info("J� foi atingida a quantidade m�xima que pode regar a planta, poder� regar somente no dia seguinte, ap�s dormir");
						planta.alterarDiaNoite();
					}
				} 
			}else {
					System.out.println("Planta est� no estado para per colida!");
					logger.info("Planta est� no estado para per colida!");
			}
		}else if(validaLuz.validarLuz(planta) == false) {
			System.out.println("Est� de noite, v� dormir...");
			logger.info("Est� de noite, v� dormir...");
		}
	}

}
