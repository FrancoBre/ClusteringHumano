package juego;

import java.util.ArrayList;

public class Vertice {
	private ArrayList<Arista> vecinos;
	private Persona i;
	
	public Vertice (Persona persona){
		this.vecinos = new ArrayList<Arista>();
		this.i=persona;
	}
}
