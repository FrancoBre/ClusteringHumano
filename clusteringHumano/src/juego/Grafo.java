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
    	this.vertices = vertices;
    	this.aristas = new ArrayList<Arista>();

    	for(int i=0; i<vertices.size(); i++) 
    		this.vertices.add(vertices.get(i));

    }
    
    public void agregarArista(Arista arista) {
    	vertices.add(arista.getVertice1());
    	vertices.add(arista.getVertice2());
    	aristas.add(arista);
    }
    
    public void eliminarArista(Arista arista) {
    	vertices.remove(arista.getVertice1());
    	vertices.remove(arista.getVertice2());
    	aristas.remove(arista);
    }
    
    public boolean existeArista(Arista arista) {
    	return arista.getVertice1().getVecinos().contains(arista.getVertice2());
    }

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}
}
