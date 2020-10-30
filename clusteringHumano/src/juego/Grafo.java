package juego;

import java.util.HashMap;

public class Grafo {
	private HashMap<String, Vertice> vertices;
    private HashMap<Integer, Arista> aristas;

    public Grafo() {
	this.vertices = new HashMap<String, Vertice>();
	this.aristas = new HashMap<Integer, Arista>();
    }

}
