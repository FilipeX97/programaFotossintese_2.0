package br.com.unip.aps.modelo.planta;

import br.com.unip.aps.modelo.Natureza;

public abstract class Planta {

	private String nomePlanta;
	private String apelidoPlanta;
	private int grupoPlanta;
	private boolean estadoPlanta;
	private int quantidadeDeLuz;
	private final static int quantidadeDeAguaTotalDoDia = 2;
	private int quantidadeDeAguaDuranteDia;
	private int quantidadeDeEnergiaNaPlanta;
	private int quantidadeEnergiaParaColherPlanta;
	private boolean colherPlanta;
	private boolean respiracaoPlanta;
	private final static int estagioInicialPlanta = 1;
	private int estagioAtualPlanta;
	private int estagioFinalPlanta;

	Natureza n = new Natureza(); 

	Planta() {
		estadoPlanta = true;
		quantidadeDeLuz = 0;
		quantidadeDeAguaDuranteDia = 0;
		quantidadeDeEnergiaNaPlanta = 0;
		colherPlanta = false;
		respiracaoPlanta = n.getAr();
		estagioAtualPlanta = estagioInicialPlanta;
	}
	
	
	public void alterarDiaNoite() {
		if (n.getLuz()) {
			n.setLuz(false);
			System.out.println("Está de noite..."
					+ "\nVá dormir...");
		} else {
			n.setLuz(true);
			System.out.println("Está de dia..."
					+ "\nCuide de sua planta...");
		}
	}
	
	public boolean isLuz() {
		return n.getLuz();
	}

	public String getNomePlanta() {
		return nomePlanta;
	}

	public void setNomePlanta(String nomePlanta) {
		this.nomePlanta = nomePlanta;
	}

	public int getGrupoPlanta() {
		return grupoPlanta;
	}

	public void setGrupoPlanta(int grupo) {
		grupoPlanta = grupo;
	}

	public boolean isEstadoPlanta() {
		return estadoPlanta;
	}

	public void setEstadoPlanta(boolean estado) {
		estadoPlanta = estado;
	}

	public int getQuantidadeDeLuz() {
		return quantidadeDeLuz;
	}

	public void setQuantidadeDeLuz(int qLuz) {
		quantidadeDeLuz = qLuz;
	}

	public int getQuantidadeDeAguaTotalDoDia() {
		return quantidadeDeAguaTotalDoDia;
	}

	public String getApelidoPlanta() {
		return apelidoPlanta;
	}

	public void setApelidoPlanta(String apelidoPlanta) {
		this.apelidoPlanta = apelidoPlanta;
	}

	public int getQuantidadeDeAguaDuranteDia() {
		return quantidadeDeAguaDuranteDia;
	}

	public void setQuantidadeDeAguaDuranteDia(int quantidadeDeAguaDia) {
		quantidadeDeAguaDuranteDia = quantidadeDeAguaDia;
	}

	public int getQuantidadeDeEnergiaNaPlanta() {
		return quantidadeDeEnergiaNaPlanta;
	}

	public void setQuantidadeDeEnergiaNaPlanta(int quantidadeDeEnergiaNaPlanta) {
		this.quantidadeDeEnergiaNaPlanta = quantidadeDeEnergiaNaPlanta;
	}

	public boolean isColherPlanta() {
		return colherPlanta;
	}

	public void setColherPlanta(boolean colherPlanta) {
		this.colherPlanta = colherPlanta;
	}

	public boolean isRespiracaoPlanta() {
		return respiracaoPlanta;
	}

	public void setRespiracaoPlanta(boolean respiracaoPlanta) {
		this.respiracaoPlanta = respiracaoPlanta;
	}

	public int getEstagioAtualPlanta() {
		return estagioAtualPlanta;
	}

	public void setEstagioAtualPlanta(int estagioAtualPlanta) {
		this.estagioAtualPlanta = estagioAtualPlanta;
	}

	public int getEstagioFinalPlanta() {
		return estagioFinalPlanta;
	}

	public void setEstagioFinalPlanta(int estagioFinalPlanta) {
		this.estagioFinalPlanta = estagioFinalPlanta;
	}
	
	public int getQuantidadeEnergiaParaColherPlanta() {
		return quantidadeEnergiaParaColherPlanta;
	}

	public void setQuantidadeEnergiaParaColherPlanta(int quantidadeEnergiaParaColherPlanta) {
		this.quantidadeEnergiaParaColherPlanta = quantidadeEnergiaParaColherPlanta;
	}


	@Override
	public String toString() {
		return "Nome da Planta= " + nomePlanta 
				+ "\nApelido da Planta= " + apelidoPlanta 
				+ "\nGrupo da Planta= " + grupoPlanta
				+ "\nEstado da Planta= " + estadoPlanta 
				+ "\nQuantidade De Luz= " + quantidadeDeLuz
				+ "\nQuantidadeDeAguaDuranteDia= " + quantidadeDeAguaDuranteDia 
				+ "\nQuantidadeDeEnergiaNaPlanta= " + quantidadeDeEnergiaNaPlanta 
				+ "\nQuantidadeEnergiaParaColherPlanta= " + quantidadeEnergiaParaColherPlanta 
				+ "\nColherPlanta= " + colherPlanta 
				+ "\nRespiracaoPlanta= "	+ respiracaoPlanta 
				+ "\nEstagioAtualPlanta= " + estagioAtualPlanta 
				+ "\nEstagioFinalPlanta= "	+ estagioFinalPlanta;
	}

	
	
}