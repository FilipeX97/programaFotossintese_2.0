package br.com.unip.aps.modelo.planta;

public class Vegetal extends Planta{
	
	public Vegetal(String nome, String apelido) {
		setNomePlanta(nome);
		setApelidoPlanta(apelido);
		setGrupoPlanta(6);
		setEstagioFinalPlanta(3);
		setQuantidadeEnergiaParaColherPlanta(9);
	}
	
}