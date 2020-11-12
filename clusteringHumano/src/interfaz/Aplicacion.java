package interfaz;

import java.util.ArrayList;

import logica.Arista;
import logica.GCompleto;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;

public class Aplicacion {

	private Grafo grafo;
	private ArrayList<Persona> personas;

	public Aplicacion() {
		this.grafo = new GCompleto();
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
		return this.grafo;
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
