package juego;

import java.util.ArrayList;

public class Vertice {
	private ArrayList<Arista> vecinos;
	private Persona i;
	
	public Vertice (Persona persona){
		this.vecinos = new ArrayList<Arista>();
		this.i = persona;
	}

	public ArrayList<Arista> getVecinos() {
		return vecinos;
	}

	public void setVecinos(ArrayList<Arista> vecinos) {
		this.vecinos = vecinos;
	}

	public Persona getPersona() {
		return i;
	}

	public void setI(Persona i) {
		this.i = i;
	}
}
