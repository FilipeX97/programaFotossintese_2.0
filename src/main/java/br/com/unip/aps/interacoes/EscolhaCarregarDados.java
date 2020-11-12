package br.com.unip.aps.interacoes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.ArquivoSave;
import br.com.unip.aps.processamento_arquivo.GerarLista_Saves;
import br.com.unip.aps.properties.PathProperties;
import br.com.unip.aps.util.ValidaEscolhaAcoes;

public class EscolhaCarregarDados {

	Scanner sc = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger(EscolhaCarregarDados.class);
	private Properties paths = PathProperties.getPathProperties();
	private Path path = Paths.get(paths.getProperty("pathArquivo"));
	private GerarLista_Saves gerarLista = new GerarLista_Saves();
	private List<ArquivoSave> listaSave = gerarLista.geraListaSaves();
	ValidaEscolhaAcoes escolha;
	String validacaoEscolha;
	
	public int escolhaCarregarDados() {
		
		if(Files.exists(path)) {
			do {
				for(int i = 0; i < listaSave.size(); i++) {
					System.out.println(
							"\n----------------	"+ i + "	----------------" + "\n" 
							+ listaSave.get(i).toString());
					logger.debug("Executando lista de Saves....");
					logger.info("\n----------------	"+ i + "	----------------" + "\n" 
							+ listaSave.get(i).toString());
				}
				
				System.out.println("\n"+listaSave.size()+" - Sair");
				
				System.out.println("\nEscolha qual arquivo deseja carregar: ");
				
				int decisao;
				validacaoEscolha = sc.nextLine();
				if(validacaoEscolha.matches("[0-9]*")) {
					decisao = Integer.parseInt(validacaoEscolha);
				}else {
					decisao = listaSave.size()+2;
				}
				
				escolha = new ValidaEscolhaAcoes(decisao);
				
				for(int i = 0;i <= listaSave.size(); i++) {
					if(decisao == i) {
						if(decisao == listaSave.size()) {
							System.exit(0);
						} else {
							logger.info("Escolha dos dados que o usuário escolheu foi: "+i);
							return i;
						}
						break;
					}
				}
				
				if(decisao > listaSave.size()) {
					System.out.println("Opção Inválida");
					logger.error("Opção Inválida");
				}
			}while(escolha.validaEscolhaLoad(listaSave.size()) == false);
		}
		return -1;
		
	}
	
}
