package br.com.unip.aps.interacoes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.unip.aps.properties.PathProperties;
import br.com.unip.aps.util.ValidaEscolhaAcoes;

public class OpcoesIniciarJogo {
	
	private ValidaEscolhaAcoes escolha;
	private boolean validarLoad = false;
	private static final Logger logger = Logger.getLogger(OpcoesIniciarJogo.class);
	private Properties paths = PathProperties.getPathProperties();
	private Path path = Paths.get(paths.getProperty("pathArquivo"));
	private String validacaoScanner;
	private int escolhaOpcoesIniciarJogo = 0;
	private Scanner sc = new Scanner(System.in);
	
	public int escolherTipoDeDados() {
		
		do {
			logger.info("Escolha de opções:");
			logger.info("1 - Novo Jogo");
			System.out.println("Opções: "
					+ "\n1 - Novo Jogo");
			
			if(Files.exists(path)) {
				validarLoad = true;
				System.out.println("2 - Carregar Jogo");
				logger.info("2 - Carregar Jogo");
			}
			
			validacaoScanner = sc.nextLine();
			
			if(validacaoScanner.matches("[0-9]*")) {
				escolhaOpcoesIniciarJogo = Integer.parseInt(validacaoScanner);
			}else {
				escolhaOpcoesIniciarJogo = 9;
			}
			
			escolha = new ValidaEscolhaAcoes(escolhaOpcoesIniciarJogo);
			
			if(escolhaOpcoesIniciarJogo != 1 && validarLoad == false) {
				System.out.println("Opção Inválida!");
				logger.info("Opção Inválida!");
				if(validarLoad == false && escolhaOpcoesIniciarJogo == 2)
					System.out.println("Não contêm load!");
				logger.info("Não contêm load!");
			}
		}
		while(escolha.validaOpcaoDeJogo(validarLoad) == false);
		
		logger.info("Usuário escolheu a opção: "+escolhaOpcoesIniciarJogo);
		
		return escolhaOpcoesIniciarJogo;
	}
	
}
