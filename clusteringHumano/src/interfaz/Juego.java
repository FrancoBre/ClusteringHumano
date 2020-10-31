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
	
	public void crearPersona(int m, int d, int e, int c) {
		this.personas.add(new Persona(m, d, e, c));
		crearAristas();
	}
	
	private void crearAristas() {
		for (int i = 0; i < personas.size(); i++) if(personas.size()>1) {
			Persona persona = personas.get(i);
			Persona ultimaPersona = personas.get(personas.size());
			
			this.grafo.agregarArista(new Arista((new Vertice(persona)), 
					(new Vertice(ultimaPersona))));
		}
	}
	
//	public void añadirArista(Persona persona1, Persona persona2) {
//		Arista arista = new Arista((new Vertice(persona1)), (new Vertice(persona2)));
//		grafo.agregarArista(arista);
//	}
	
	public int tamanioGrafo() {
		return this.grafo.getVertices().size();
	}
	
/*	
	public Arista aristaDeMayorPeso() {
		
	}
	
	public int cantComponentesConexas() {

	}
*/
	
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
