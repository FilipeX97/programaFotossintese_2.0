package br.com.unip.aps.modelo.planta;

public class Tempero extends Planta{
	
	public Tempero(String nome, String apelido) {
		setNomePlanta(nome);
		setApelidoPlanta(apelido);
		setGrupoPlanta(5);
		setEstagioFinalPlanta(2);
		setQuantidadeEnergiaParaColherPlanta(6);
	}
	
}
