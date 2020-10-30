package juego;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;

    public Grafo() {
	this.vertices = new ArrayList<Vertice>();
	this.aristas = new ArrayList<Arista>();
    }

    public Grafo(ArrayList<Vertice> vertices) {
	this.vertices = new ArrayList<Vertice>();
	this.aristas = new ArrayList<Arista>();

	for(int i=0; i<vertices.size(); i++) 
		this.vertices.add(vertices.get(i));

    }
}
