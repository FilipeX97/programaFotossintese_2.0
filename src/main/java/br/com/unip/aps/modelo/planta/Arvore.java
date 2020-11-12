package br.com.unip.aps.modelo.planta;

public class Arvore extends Planta{
	
	public Arvore(String nome, String apelido) {
		setNomePlanta(nome);
		setApelidoPlanta(apelido);
		setGrupoPlanta(1);
		setEstagioFinalPlanta(3);
		setQuantidadeEnergiaParaColherPlanta(12);
	}

}
