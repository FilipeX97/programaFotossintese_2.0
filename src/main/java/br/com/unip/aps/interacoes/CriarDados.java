package br.com.unip.aps.interacoes;

import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.unip.aps.manipulacao.pessoa.CriarPessoa;
import br.com.unip.aps.manipulacao.planta.CriarPlanta;
import br.com.unip.aps.modelo.Pessoa;
import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.util.ValidaEscolhaAcoes;

public class CriarDados {
	
	private static final Logger logger = Logger.getLogger(CriarDados.class);
	Scanner sc = new Scanner(System.in);
	
	public Pessoa criarDadosPessoa() {
		
		String nomePessoa;
		
		do {
			System.out.println("Digite o Nome da Pessoa: ");
			nomePessoa = sc.nextLine();
			if(nomePessoa.length() == 0) {
				System.out.println("Digitação Inválida, não deixe o campo em branco");
				logger.error("Digitação Inválida, não deixe o campo em branco");
			}
		}
		while(nomePessoa.length() == 0);
		
		CriarPessoa criarPessoa = new CriarPessoa();
		Pessoa pessoa = criarPessoa.criarPessoa(nomePessoa);
		
		return pessoa;
		
	}
	
	public Planta criarDadosPlanta() {
		
		String validacaoScanner;
		int escolhaCriarDadosPlanta;
		ValidaEscolhaAcoes escolha;
		
		do {
			System.out.println("Escolha a Categoria da sua Planta: \n" +
					"1 - Árvore\n" + 
					"2 - Flor\n" + 
					"3 - Fruta\n" + 
					"4 - Legume\n" + 
					"5 - Tempero\n" + 
					"6 - Vegetal");
			
			validacaoScanner = sc.nextLine();
			if(validacaoScanner.matches("[0-9]*")) {
				escolhaCriarDadosPlanta = Integer.parseInt(validacaoScanner);
			}else {
				escolhaCriarDadosPlanta = 9;
			}
			
			escolha = new ValidaEscolhaAcoes(escolhaCriarDadosPlanta);
			if(escolha.validarCriacaoPlanta() == false) {
				System.out.println("Opção Inválida!");
				logger.error("Opção Inválida!");
			}
		}
		while(escolha.validarCriacaoPlanta() == false);
		
		CriarPlanta criarPlanta = new CriarPlanta(escolhaCriarDadosPlanta);
		String nomePlanta, apelidoPlanta;
		
		logger.info("Categoria da planta: "+escolhaCriarDadosPlanta);
		
		do {
			System.out.println("Digite o nome da Planta: ");
			nomePlanta = sc.nextLine();
			System.out.println("Digite o Apelido da Planta");
			apelidoPlanta = sc.nextLine();
			
			if(nomePlanta.length() == 0) {
				System.out.println("Nome da planta inválida!");
				logger.error("Nome da planta inválida!");
			}
			if(apelidoPlanta.length() == 0) {
				System.out.println("Apelido da planta inválida!");
				logger.error("Apelido da planta inválida!");
			}
		}
		while(nomePlanta.length() == 0 || apelidoPlanta.length() == 0);
		
		logger.info("Nome da planta escolhida: "+nomePlanta);
		logger.info("Apelido da planta escolhida: "+apelidoPlanta);
		
		Planta planta = criarPlanta.criar(nomePlanta, apelidoPlanta);
		return planta;
	}
	
}
