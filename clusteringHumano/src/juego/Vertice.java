package juego;

import java.util.ArrayList;

public class Vertice {
	private ArrayList<Vertice> vecinos;
	private Persona i;
	
	public Vertice (Persona persona) {
		this.vecinos = new ArrayList<Vertice>();
		this.i = persona;
	}
 
	public void insertarVecino(Vertice vertice) {
		if(!this.vecinos.contains(vertice))
			this.vecinos.add(vertice);
	}
	
	public boolean contiene(Arista arista) {
		return this.vecinos.contains(arista);
	}
	
	public void eliminarVecino(Arista arista) {
		this.vecinos.remove(arista);
	}
	
	public boolean tieneVecino(Vertice vertice) {
		return vertice.vecinos.isEmpty();
	}
	
	public ArrayList<Vertice> getVecinos() {
		return vecinos;
	}

	public void setVecinos(ArrayList<Vertice> vecinos) {
		this.vecinos = vecinos;
	}

	public Persona getPersona() {
		return i;
	}

	public void setI(Persona i) {
		this.i = i;
	}
}
