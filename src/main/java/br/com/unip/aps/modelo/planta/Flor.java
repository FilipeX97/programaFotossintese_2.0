package br.com.unip.aps.modelo.planta;

public class Flor extends Planta{
	
	public Flor(String nome, String apelido) {
		setNomePlanta(nome);
		setApelidoPlanta(apelido);
		setGrupoPlanta(2);
		setEstagioFinalPlanta(2);
		setQuantidadeEnergiaParaColherPlanta(6);
	}
	
}
