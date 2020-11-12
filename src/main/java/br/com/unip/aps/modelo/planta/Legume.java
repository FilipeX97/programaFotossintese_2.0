package br.com.unip.aps.modelo.planta;

public class Legume extends Planta{
	
	public Legume(String nome, String apelido) {
		setNomePlanta(nome);
		setApelidoPlanta(apelido);
		setGrupoPlanta(4);
		setEstagioFinalPlanta(3);
		setQuantidadeEnergiaParaColherPlanta(9);
	}
	
}
