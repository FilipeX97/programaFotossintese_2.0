package br.com.unip.aps.main;

import org.apache.log4j.Logger;

import br.com.unip.aps.interacoes.CriarDados;
import br.com.unip.aps.interacoes.EscolhaCarregarDados;
import br.com.unip.aps.interacoes.IniciarJogo;
import br.com.unip.aps.interacoes.Menu;
import br.com.unip.aps.interacoes.OpcoesIniciarJogo;
import br.com.unip.aps.modelo.Pessoa;
import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.processamento_arquivo.Load_Arquivo;

public class TestaPrograma {
	
	private static final Logger logger = Logger.getLogger(TestaPrograma.class);
	
	public static void main(String[] args) {
		
		Pessoa p = null;
		Planta pl = null;
		CriarDados criarDados;
		Load_Arquivo load;
		Menu menu;
		
		logger.info("-----------------------------------------------------------------------------------");
		logger.info("							Jogo <<-- Planta -->>									");
		logger.info("-----------------------------------------------------------------------------------");
		
		logger.debug("Iniciando Jogo...");
		
		IniciarJogo iniciarJogo = new IniciarJogo();
		if(iniciarJogo.iniciar() == 1) {
			OpcoesIniciarJogo opInicarJogo = new OpcoesIniciarJogo();
			int opcaoEscolhaTrocarDados;
			do {
				opcaoEscolhaTrocarDados = opInicarJogo.escolherTipoDeDados();
				if (opcaoEscolhaTrocarDados == 1) {
					criarDados = new CriarDados();
					p = criarDados.criarDadosPessoa();
					pl = criarDados.criarDadosPlanta();
				} else {
					load = new Load_Arquivo();
					EscolhaCarregarDados escolha = new EscolhaCarregarDados();
					int numeroSave = escolha.escolhaCarregarDados();
					if(numeroSave >= 0) {
						p = load.loadArquivoPessoa(numeroSave);
						pl = load.loadArquivoPlanta(numeroSave);
						System.out.println("\nJogo Carregado !\n");
						logger.info("\nJogo Carregado !\n");
					} else {
						System.out.println("Não contêm save!");
						logger.error("Não contêm save!");
					}
				}
				menu = new Menu();
				opcaoEscolhaTrocarDados = menu.menu(pl, p);
			} while(opcaoEscolhaTrocarDados != 8);
		}
		
		logger.info("Jogo encerrado, obrigado por jogar................");
		
		
	}
	
}