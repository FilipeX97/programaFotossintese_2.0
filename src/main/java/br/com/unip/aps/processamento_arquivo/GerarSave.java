package br.com.unip.aps.processamento_arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.unip.aps.modelo.ArquivoSave;
import br.com.unip.aps.modelo.Pessoa;
import br.com.unip.aps.modelo.planta.Planta;
import br.com.unip.aps.properties.PathProperties;

public class GerarSave {
	
	private static final Logger logger = Logger.getLogger(GerarSave.class);
	private static Properties paths = PathProperties.getPathProperties();
	private static Path path = Paths.get(paths.getProperty("pathArquivo"));
	
	static {
		if(Files.notExists(path)) {
			try {
				Files.createFile(Paths.get(
						paths.getProperty("pathArquivo")));
				logger.info("Arquivo save carregado!");
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
	}
	
	private GerarLista_Saves gerarLista = new GerarLista_Saves();
	private List<ArquivoSave> listaSave = gerarLista.geraListaSaves();
	
	public void gerarSave(Planta pl, Pessoa p) {
		
		if(listaSave.size() == 0) {
			
			ArquivoSave save = new ArquivoSave(
					p.getNomePessoa(),
					pl.getNomePlanta(),
					pl.getApelidoPlanta(),
					pl.getGrupoPlanta(),
					pl.isEstadoPlanta(),
					pl.getQuantidadeDeEnergiaNaPlanta(),
					pl.getEstagioAtualPlanta());
			
			listaSave.add(save);
			
			StringBuilder sb = new StringBuilder();
			
			for(ArquivoSave saveFor : listaSave) {
				
				sb.append(saveFor.textoSave()).append(System.lineSeparator());
				
			}
			
			try {
				Files.write(path, sb.toString().getBytes());
				logger.debug("Inserindo primeiro save no arquivo");
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
			
			
			
		} else {
			
			ArquivoSave save = new ArquivoSave(
					p.getNomePessoa(),
					pl.getNomePlanta(),
					pl.getApelidoPlanta(),
					pl.getGrupoPlanta(),
					pl.isEstadoPlanta(),
					pl.getQuantidadeDeEnergiaNaPlanta(),
					pl.getEstagioAtualPlanta());
			
			listaSave.add(save);
			
			try {
				
				Files.deleteIfExists(path);
				StringBuilder sb = new StringBuilder();
				
				for(ArquivoSave saveFor : listaSave) {
					
					sb.append(saveFor.textoSave()).append(System.lineSeparator());
					
				}
				
				Files.write(path, sb.toString().getBytes(), StandardOpenOption.CREATE_NEW);
				logger.info("Inserindo lista com mais de um save!");
			
			} catch (IOException e) {
				
				logger.error(e.getMessage());
				
			}
			
			System.out.println(listaSave.size());
			
		}
		
	}

}
