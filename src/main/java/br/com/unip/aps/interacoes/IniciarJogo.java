package br.com.unip.aps.interacoes;

import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.unip.aps.util.ValidaEscolhaAcoes;


public class IniciarJogo {
	
	private static final Logger logger = Logger.getLogger(IniciarJogo.class);
	
	public int iniciar() {
		
		ValidaEscolhaAcoes escolha;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String validacaoScanner;
		int escolhaIniciar = 0;
		
		System.out.println("Bem Vindo ao Programa Fotoss�ntese"
				+ "\nEscolha uma op��o para continuar: ");
		logger.info("\nBem Vindo ao Programa Fotoss�ntese"
				+ "\nEscolha uma op��o para continuar: ");
		do {
			System.out.println("1 - Iniciar Jogo");
			System.out.println("0 - Fechar Jogo");
		
			validacaoScanner = sc.nextLine();
			if(validacaoScanner.matches("[0-9]*")) {
				escolhaIniciar = Integer.parseInt(validacaoScanner);
			}else {
				escolhaIniciar = 9;
			}
			
			escolha = new ValidaEscolhaAcoes(escolhaIniciar);
			
			if(escolhaIniciar != 0 && escolhaIniciar != 1) {
				System.out.println("Op��o Inv�lida!");
				logger.error("Op��o Inv�lida!");
			}
		}
		while (escolha.validaIniciar() == false);
		
		logger.info("Usu�rio escolheu a op��o: "+escolhaIniciar);
		
		if(escolhaIniciar == 0) {
			logger.info("Jogo encerrado, obrigado por jogar................");
			System.exit(0);
		}
		
		return escolhaIniciar;
	}

}
