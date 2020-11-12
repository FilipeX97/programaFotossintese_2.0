package br.com.unip.aps.manipulacao.planta;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.planta.Arvore;
import br.com.unip.aps.modelo.planta.Flor;
import br.com.unip.aps.modelo.planta.Fruta;
import br.com.unip.aps.modelo.planta.Legume;
import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.modelo.planta.Tempero;
import br.com.unip.aps.modelo.planta.Vegetal;

public class CriarPlanta {
	
	private static final Logger logger = Logger.getLogger(CriarPlanta.class);
	int escolherPlanta;
	
	public CriarPlanta(int escolher){
		escolherPlanta = escolher;
	}
	
	public Planta criar(String nomePlanta, String apelidoPlanta) {
		
		if (escolherPlanta == 1) {
			Planta arvore = new Arvore(nomePlanta, apelidoPlanta);
			System.out.println("Árvore criada!"
					+ "\nO nome é: " + arvore.getNomePlanta()
					+ "\nE seu apelido: " + arvore.getApelidoPlanta());
			logger.info("Árvore criada!");
			return arvore;
		} 
			
		if (escolherPlanta == 2) {
			Planta flor = new Flor(nomePlanta, apelidoPlanta);
			System.out.println("Flor criada!"
					+ "\nO nome é: " + flor.getNomePlanta()
					+ "\nE seu apelido: " + flor.getApelidoPlanta());
			logger.info("Flor criada!");
			return flor;
		} 
		
		if (escolherPlanta == 3) {
			Planta fruta = new Fruta(nomePlanta, apelidoPlanta);
			System.out.println("Fruta criada!"
					+ "\nO nome é: " + fruta.getNomePlanta()
					+ "\nE seu apelido: " + fruta.getApelidoPlanta());
			logger.info("Fruta criada!");
			return fruta;
		} 
		
		if (escolherPlanta == 4) {
			Planta legume = new Legume(nomePlanta, apelidoPlanta);
			System.out.println("Legume criado!"
					+ "\nO nome é: " + legume.getNomePlanta()
					+ "\nE seu apelido: " + legume.getApelidoPlanta());
			logger.info("Legume criado!");
			return legume;
		} 
		
		if (escolherPlanta == 5) {
			Planta tempero = new Tempero(nomePlanta, apelidoPlanta);
			System.out.println("Tempero criado!"
					+ "\nO nome é: " + tempero.getNomePlanta()
					+ "\nE seu apelido: " + tempero.getApelidoPlanta());
			logger.info("Tempero criado!");
			return tempero;
		} 
		
		if (escolherPlanta == 6) {
			Planta vegetal = new Vegetal(nomePlanta, apelidoPlanta);
			System.out.println("Vegetal criado!"
					+ "\nO nome é: " + vegetal.getNomePlanta()
					+ "\nE seu apelido: " + vegetal.getApelidoPlanta());
			logger.info("Vegetal criado!");
			return vegetal;
		} 
		
		return null;
		
	}

}
