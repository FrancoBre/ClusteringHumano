package logica;

import java.util.ArrayList;

public class Grafo {
	
	private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;

    public Grafo() {
    	this.vertices = new ArrayList<Vertice>();
    	this.aristas = new ArrayList<Arista>();
    }
    
    public void agregarArista(Arista arista) {
		Arista alReves = new Arista(arista.getVertice2(), arista.getVertice1());
    	
    	if((!this.getAristas().contains(arista) || !this.getAristas().contains(alReves)) && 
    			!arista.getVertice1().equals(arista.getVertice2())) {	
	    		
    		this.getAristas().add(arista);
	    	 
    		if(!this.getVertices().contains(arista.getVertice1())) {
    			this.getVertices().add(arista.getVertice1());
    		}
    		
    		if(!this.getVertices().contains(arista.getVertice2())) {
    			this.getVertices().add(arista.getVertice2());
    		}
    	}
	}

	public void eliminarArista(Arista arista) {
    	getAristas().remove(arista);
    	arista.getVertice1().eliminarVecino(arista.getVertice2());
    	arista.getVertice2().eliminarVecino(arista.getVertice1());
    }
	
	public void eliminarVertice(Vertice vertice) {
		getVertices().remove(vertice);
	}
    
    public boolean existeArista(Arista arista) {
		Arista alReves = new Arista(arista.getVertice2(), arista.getVertice1());
    	return this.getAristas().contains(arista) || this.getAristas().contains(alReves);
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
