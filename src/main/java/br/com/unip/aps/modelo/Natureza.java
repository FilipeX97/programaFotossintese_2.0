package br.com.unip.aps.modelo;

public class Natureza {
	private boolean luzSol;
	private final boolean ar = true;
	
	public Natureza(){
		luzSol = true;
	}
	
	public boolean getLuz() {
		return luzSol;
	}
	
	public void setLuz(boolean luz) {
		luzSol = luz;
	}
	
	public boolean getAr() {
		return ar;
	}
	
}
