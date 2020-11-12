package br.com.unip.aps.processamento_arquivo;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.unip.aps.manipulacao.planta.CriarPlanta;
import br.com.unip.aps.modelo.ArquivoSave;
import br.com.unip.aps.modelo.Pessoa;
import br.com.unip.aps.modelo.planta.Planta;

public class Load_Arquivo {
	
	private static final Logger logger = Logger.getLogger(Load_Arquivo.class);
	private GerarLista_Saves gerarLista = new GerarLista_Saves();
	private List<ArquivoSave> listaSave = gerarLista.geraListaSaves();
	
	public Pessoa loadArquivoPessoa(int numeroSave) {
		
		Pessoa pessoa = new Pessoa(listaSave.get(numeroSave).getNomePessoa());
		logger.debug("Save da classe pessoa carregado");
		return pessoa;
		
	}
	
	public Planta loadArquivoPlanta(int numeroSave) {
		
		CriarPlanta criarPlanta = new CriarPlanta(listaSave.get(numeroSave).getGrupoPlanta());
		
		Planta planta = criarPlanta.criar(
				listaSave.get(numeroSave).getNomePlanta(), 
				listaSave.get(numeroSave).getApelidoPlanta());
		
		planta.setEstadoPlanta(listaSave.get(numeroSave).isEstadoPlanta());
		planta.setQuantidadeDeEnergiaNaPlanta(
				listaSave.get(numeroSave).getQuantidadeEnergiaPlanta());
		planta.setEstagioAtualPlanta(listaSave.get(numeroSave).getEstagioAtualPlanta());
		
		logger.debug("Save da classe planta carregado!");
		return planta;
		
	}

}
