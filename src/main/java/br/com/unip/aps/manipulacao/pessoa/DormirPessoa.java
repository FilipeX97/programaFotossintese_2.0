package br.com.unip.aps.manipulacao.pessoa;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.Pessoa;
import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.util.ValidaLuz;

public class DormirPessoa {
	
	private static final Logger logger = Logger.getLogger(DormirPessoa.class);

	public void dormirPessoa(Pessoa pessoa, Planta planta) {

		ValidaLuz validaLuz = new ValidaLuz();
		
		if(planta.getQuantidadeDeEnergiaNaPlanta() != planta.getQuantidadeEnergiaParaColherPlanta()) {

			if (validaLuz.validarLuz(planta) == false) {
				System.out.println("Dormindo....");
				logger.info("Pessoa Dormindo");
	
				planta.setQuantidadeDeEnergiaNaPlanta(planta.getQuantidadeDeEnergiaNaPlanta() + 1);
				pessoa.setQuatidadeRegaPlanta(0);
				planta.setQuantidadeDeAguaDuranteDia(0);
				
				if(planta.getGrupoPlanta() == 1) {
					if(planta.getQuantidadeEnergiaParaColherPlanta() == 5) {
						planta.setEstagioAtualPlanta(2);
					} else if (planta.getQuantidadeEnergiaParaColherPlanta() == 9){
						planta.setEstagioAtualPlanta(3);
					}
				}
				
				if(planta.getGrupoPlanta() == 3 || planta.getGrupoPlanta() == 4 || planta.getGrupoPlanta() == 6) {
					if(planta.getQuantidadeEnergiaParaColherPlanta() == 4) {
						planta.setEstagioAtualPlanta(2);
					} else if (planta.getQuantidadeEnergiaParaColherPlanta() == 7){
						planta.setEstagioAtualPlanta(3);
					}
				}
				
				if(planta.getGrupoPlanta() == 2 || planta.getGrupoPlanta() == 5) {
					if(planta.getQuantidadeEnergiaParaColherPlanta() == 4) {
						planta.setEstagioAtualPlanta(2);
					}
				}
	
				System.out.println("Acordado!");
				logger.info("Pessoa Acordada!");
	
				planta.alterarDiaNoite();
			} else {
				System.out.println("Ainda está de dia, cuide da sua planta, regue-a até anoitecer");
				logger.info("Não poderá colher a planta!");
				logger.info("Ainda está de dia, cuide da sua planta, regue-a até anoitecer");
			}
		} else {
			System.out.println("Planta está no estado para ser colida!");
			logger.info("Planta está no estado para ser colida!");
		}
	}
	
}
