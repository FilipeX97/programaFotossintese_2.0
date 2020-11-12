package br.com.unip.aps.manipulacao.pessoa;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.Pessoa;

public class CriarPessoa {
	
	private static final Logger logger = Logger.getLogger(CriarPessoa.class);
	
	public Pessoa criarPessoa(String nomePessoa) {
		Pessoa p = new Pessoa(nomePessoa);
		System.out.println("Pessoa criada, bem vindo " + p.getNomePessoa());
		logger.info("Pessoa criada, bem vindo " + p.getNomePessoa());
		return p;
	}

}
