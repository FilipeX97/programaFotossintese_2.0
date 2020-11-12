package br.com.unip.aps.interacoes;

import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.unip.aps.manipulacao.pessoa.DormirPessoa;
import br.com.unip.aps.manipulacao.planta.ColherPlanta;
import br.com.unip.aps.manipulacao.planta.MatarPlanta;
import br.com.unip.aps.manipulacao.planta.RegarPlanta;
import br.com.unip.aps.modelo.Pessoa;
import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.processamento_arquivo.GerarSave;
import br.com.unip.aps.processamento_arquivo.Load_Arquivo;
import br.com.unip.aps.util.ValidaEscolhaAcoes;

public class Menu {
	
	private static final Logger logger = Logger.getLogger(Menu.class);
	Scanner sc = new Scanner(System.in);
	RegarPlanta regar;
	ColherPlanta colher;
	MatarPlanta matar;
	DormirPessoa dormir;
	GerarSave salvar;
	Load_Arquivo load;
	ValidaEscolhaAcoes escolha;
	String validacaoEscolha;

	public int menu (Planta pl, Pessoa p) {
		
		int escolhaMenu;
		
		do {
			do {
				
				logger.info("Opções de escolha");
				logger.info("\n"+"----------------------------"
						+p.getNomePessoa() +", escolha uma ação..."
						+"----------------------------"
						+ "\n1 - Colocar Água"
						+ "\n2 - Exibir informações"
						+ "\n3 - Colher"
						+ "\n4 - Dormir"
						+ "\n5 - Matar Planta"
						+ "\n6 - Salvar"
						+ "\n7 - Carregar Outro Save"
						+ "\n8 - Sair"
						+ "\nEscolha: ");
				
				System.out.println("--------------------------------------------------");
				System.out.println(p.getNomePessoa() + ", escolha uma ação..."
						+ "\n1 - Colocar Água"
						+ "\n2 - Exibir informações"
						+ "\n3 - Colher"
						+ "\n4 - Dormir"
						+ "\n5 - Matar Planta"
						+ "\n6 - Salvar"
						+ "\n7 - Carregar Outro Save"
						+ "\n8 - Sair"
						+ "\nEscolha: ");
				
				validacaoEscolha = sc.nextLine();
				if(validacaoEscolha.matches("[0-9]*")) {
					escolhaMenu = Integer.parseInt(validacaoEscolha);
				}else {
					escolhaMenu = 9;
				}
				
				escolha = new ValidaEscolhaAcoes(escolhaMenu);
				
				if(escolha.validaAcao() == false) {
					System.out.println("Opção Inválida!");
					logger.info("Opção Inválida");
				}
			}
			while(escolha.validaAcao() == false);
			
			logger.info("Usuário escolheu a opção: "+escolhaMenu);
			
			if(escolhaMenu == 1) {
				regar = new RegarPlanta();
				regar.regarPlanta(p, pl);
			}
			
			if(escolhaMenu == 2) {
				
				System.out.println(
						p.toString() + "\n" 
						+ pl.toString()
						);
				logger.info("Exibindo informações: ");
				logger.info("\n"+p.toString() + "\n" 
						+ pl.toString()+"\n");
				
			}
			
			if(escolhaMenu == 3) {
				colher = new ColherPlanta();
				colher.colherPlanta(pl);
			}
			
			if(escolhaMenu == 4) {
				dormir = new DormirPessoa();
				dormir.dormirPessoa(p, pl);
			}
			
			if(escolhaMenu == 5) {
				matar = new MatarPlanta();
				matar.matarPlanta(pl);
			}

			if(escolhaMenu == 6) {
				salvar = new GerarSave();
				salvar.gerarSave(pl, p);
			}

			if(escolhaMenu == 7) {
				load = new Load_Arquivo();
				EscolhaCarregarDados escolha = new EscolhaCarregarDados();
				int numeroSave = escolha.escolhaCarregarDados();
				if(numeroSave >= 0) {
					p = load.loadArquivoPessoa(numeroSave);
					pl = load.loadArquivoPlanta(numeroSave);
				} else {
					System.out.println("Não contêm save!");
					logger.error("Não contêm save!");
				}
			}
		}
		while(escolhaMenu != 8);
		
		return 8;
	}
	
}
