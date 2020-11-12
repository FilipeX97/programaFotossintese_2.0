package br.com.unip.aps.modelo.planta;

public class Fruta extends Planta{
	
	public Fruta(String nome, String apelido) {
		setNomePlanta(nome);
		setApelidoPlanta(apelido);
		setGrupoPlanta(3);
		setEstagioFinalPlanta(3);
		setQuantidadeEnergiaParaColherPlanta(9);
	}
	
}
