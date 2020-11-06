package interfaz;

import java.util.ArrayList;

import juego.Arista;
import juego.Grafo;
import juego.Persona;
import juego.Vertice;

public class Juego {

	private Grafo grafo;
	private ArrayList<Persona> personas;

	public Juego() {
		this.grafo = new Grafo();
		this.personas = new ArrayList<Persona>();
	}
	
	public void crearPersona(Persona persona) {
		this.personas.add(persona);
		crearAristas();
	}
	
	private void crearAristas() {
		if(personas.size()>=2) {
			Vertice v1 = new Vertice(personas.get(personas.size()-1));
			Vertice v2 = new Vertice(personas.get(personas.size()-2));
			Arista arista = new Arista(v1, v2);
			
			this.grafo.agregarArista(arista);
		}
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
