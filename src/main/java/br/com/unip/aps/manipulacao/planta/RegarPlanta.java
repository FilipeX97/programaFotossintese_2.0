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
						
						logger.info("Usuário tentou colher a planta sem estar no estado adequado!");
						logger.info("\n"+
							pessoa.getNomePessoa() 
							+ ", ainda falta regar " 
							+ (planta.getQuantidadeDeAguaTotalDoDia() - planta.getQuantidadeDeAguaDuranteDia()) 
							+ " vez(es) durante o dia.");
					} else {
						System.out.println("Já foi atingida a quantidade máxima que pode regar a planta, poderá regar somente no dia seguinte, após dormir");
						logger.info("Já foi atingida a quantidade máxima que pode regar a planta, poderá regar somente no dia seguinte, após dormir");
						planta.alterarDiaNoite();
					}
				} 
			}else {
					System.out.println("Planta está no estado para per colida!");
					logger.info("Planta está no estado para per colida!");
			}
		}else if(validaLuz.validarLuz(planta) == false) {
			System.out.println("Está de noite, vá dormir...");
			logger.info("Está de noite, vá dormir...");
		}
	}

}
