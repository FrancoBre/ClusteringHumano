package interfaz;

import java.util.ArrayList;

import juego.Arista;
import juego.Grafo;
import juego.Persona;
import juego.Vertice;

public class Juego {

	private Grafo grafo;
	private ArrayList<Persona> personas;
	private ArrayList<Arista> aristas;
	int tamanioGrafo;

	public Juego() {
		this.grafo = new Grafo();
		this.personas = new ArrayList<Persona>();
	}
	
	public void crearPersona(int m, int d, int e, int c) {
		this.personas.add(new Persona(m, d, e, c));
		crearAristas();
	}
	
	private void crearAristas() {
		for (int i = 0; i < personas.size(); i++) if(personas.size()>1) {
			Persona persona = personas.get(i);
			Persona ultimaPersona = personas.get(personas.size()-1);
			
			Arista nuevaArista = new Arista((new Vertice(persona)), (new Vertice(ultimaPersona)));
			
			this.grafo.agregarArista(nuevaArista);
			this.aristas.add(nuevaArista);
			this.tamanioGrafo=+1;
		}
	}
	
	public void eliminarAristaDeMayorPeso() {
		Arista max = aristas.get(0);
		
		for(Arista a : aristas) 
			if(a.getPeso() > max.getPeso()) max = a;
		
		this.grafo.eliminarArista(max);
	}
	
	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
}
