package br.com.unip.aps.modelo;

public class ArquivoSave {
	
	private String nomePessoa;
	private String nomePlanta;
	private String apelidoPlanta;
	private int grupoPlanta;
	private boolean estadoPlanta;
	private int quantidadeEnergiaPlanta;
	private int estagioAtualPlanta;
	
	public ArquivoSave(String nomePessoa, String nomePlanta, String apelidoPlanta, int grupoPlanta,
			boolean estadoPlanta, int quantidadeEnergiaPlanta, int estagioAtualPlanta) {
		super();
		this.nomePessoa = nomePessoa;
		this.nomePlanta = nomePlanta;
		this.apelidoPlanta = apelidoPlanta;
		this.grupoPlanta = grupoPlanta;
		this.estadoPlanta = estadoPlanta;
		this.quantidadeEnergiaPlanta = quantidadeEnergiaPlanta;
		this.estagioAtualPlanta = estagioAtualPlanta;
	}
	
	public String getNomePessoa() {
		return nomePessoa;
	}
	public String getNomePlanta() {
		return nomePlanta;
	}
	public String getApelidoPlanta() {
		return apelidoPlanta;
	}
	public int getGrupoPlanta() {
		return grupoPlanta;
	}
	public boolean isEstadoPlanta() {
		return estadoPlanta;
	}
	public int getQuantidadeEnergiaPlanta() {
		return quantidadeEnergiaPlanta;
	}
	public int getEstagioAtualPlanta() {
		return estagioAtualPlanta;
	}
	
	@Override
	public String toString() {
		return "\nNome da Pessoa= " + nomePessoa 
				+ "\nNome da Planta= " + nomePlanta 
				+ "\nApelido da Planta= "	+ apelidoPlanta 
				+ "\nGrupo da Planta= " + grupoPlanta 
				+ "\nEstado da Planta= " + estadoPlanta
				+ "\nQuantidade de Energia da Planta= " + quantidadeEnergiaPlanta 
				+ "\nEstágio Atual da Planta= " + estagioAtualPlanta;
	}

	public String textoSave() {
		return nomePessoa+";"
				+nomePlanta+";"
				+apelidoPlanta+";"
				+grupoPlanta+";"
				+estadoPlanta+";"
				+quantidadeEnergiaPlanta+";"
				+estagioAtualPlanta;
	}
}
