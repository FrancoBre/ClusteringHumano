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
	
	public boolean contiene(Vertice vertice) {
		return this.vecinos.contains(vertice);
	}
	
	public void eliminarVecino(Arista arista) {
		arista.getVertice1().vecinos.remove(arista.getVertice2());
		arista.getVertice2().vecinos.remove(arista.getVertice1());
	}
	
	public void eliminarVecino(Vertice vertice) {
		this.vecinos.remove(vertice);
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

	@Override
	public boolean equals(Object o) {
		Vertice vertice = (Vertice) o;
		
		if(this.i.equals(vertice.getPersona())) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("["+this.i.toString()+"].\nCon los vecinos: ");
		
		for (int i = 0; i < this.vecinos.size(); i++) 
			string.append(vecinos.get(i).toString());
		
		return string.toString();
		
	}
	
}
