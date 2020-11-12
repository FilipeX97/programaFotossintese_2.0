package br.com.unip.aps.processamento_arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.ArquivoSave;
import br.com.unip.aps.properties.PathProperties;

public class GerarLista_Saves {
	
	private static final Logger logger = Logger.getLogger(GerarLista_Saves.class);
	private Properties paths = PathProperties.getPathProperties();
	private Path path = Paths.get(paths.getProperty("pathArquivo"));
	
	private static final int estagioAtualPlanta = 6;
	private static final int quantidadeEnergiaPlanta = 5;
	private static final int estadoPlanta = 4;
	private static final int grupoPlanta = 3;
	private static final int apelidoPlanta = 2;
	private static final int nomePlanta = 1;
	private static final int nomePessoa = 0;

	public List<ArquivoSave> geraListaSaves(){
		
		ArquivoSave arquivo = null;
		List<String> linhas = null;
		List<ArquivoSave> listaDeSaves = new ArrayList<>();
		
		try {
			linhas = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(String linha : linhas) {
			
			String[] valores = linha.split(";");
			
			arquivo = new ArquivoSave(
					valores[nomePessoa],
					valores[nomePlanta],
					valores[apelidoPlanta],
					Integer.parseInt(valores[grupoPlanta]),
					Boolean.parseBoolean(valores[estadoPlanta]),
					Integer.parseInt(valores[quantidadeEnergiaPlanta]),
					Integer.parseInt(valores[estagioAtualPlanta])
					);
			
			listaDeSaves.add(arquivo);
			
		}
		
		logger.debug("Lista de save gerada!");
		return listaDeSaves;
	}
	
}
