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
	
	public static void main(String[] args) {
		Juego juego = new Juego();
		Persona persona = new Persona(3, 2, 3, 5, "Juan Carlos Pachorra");
		Persona persona2 = new Persona(1, 4, 4, 2, "Horacio Gómez");
		Persona persona3 = new Persona(5, 1, 1, 2, "Pedro Arrizabalaga");
		
		juego.crearPersona(persona);
		juego.crearPersona(persona2);
		juego.crearPersona(persona3);
		
		Vertice v1 = new Vertice(persona);
		Vertice v2 = new Vertice(persona2);
		Vertice v3 = new Vertice(persona3);
		
		for (int i = 0; i < juego.getGrafo().getAristas().size(); i++) {
			System.out.println(juego.getGrafo().getAristas().get(i).toString());
		}	

	}
	
}
