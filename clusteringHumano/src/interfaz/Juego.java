package interfaz;

import juego.Arista;
import juego.Grafo;
import juego.Persona;
import juego.Vertice;

public class Juego {

	Grafo grafo;
	
	public Juego() {
		this.grafo=new Grafo();
	}
	
	public Persona crearPersona(int m, int d, int e, int c) {
		return new Persona(m, d, e, c);
	}
	
	public void añadirArista(Persona persona1, Persona persona2) {
		Arista arista= new Arista((new Vertice(persona1)), (new Vertice(persona2)));
		grafo.agregarArista(arista);
	}
	
}
