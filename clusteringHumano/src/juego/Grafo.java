package juego;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;

    public Grafo() {
    	this.vertices = new ArrayList<Vertice>();
    	this.aristas = new ArrayList<Arista>();
    }
    
    /*
    public Grafo(ArrayList<Arista> aristas) {
    	this.aristas = aristas;
    	this.vertices = new ArrayList<Vertice>();

    	for(int i=0; i<vertices.size(); i++) { 
    		this.vertices.add(aristas.get(i).getVertice1());
    		this.vertices.add(aristas.get(i).getVertice2());
    	}

    }*/
    
    public void agregarArista(Arista arista) {
 
    	if(!aristas.contains(arista)) {
    		vertices.add(arista.getVertice1());
    		vertices.add(arista.getVertice2());
    		aristas.add(arista);
    		
    		aristasGrafoCompleto(arista);
    	}
    	
    }
    
    private void aristasGrafoCompleto(Arista arista) {
	    if(this.aristas.size() > 2) {
	    	ArrayList<Arista> aux = new ArrayList<Arista>();
	    	
    		for(Arista a : this.aristas) {
				Vertice i = a.getVertice1();
				Vertice j = a.getVertice2();
				
				Vertice v1 = arista.getVertice1();
				Vertice v2 = arista.getVertice2();
			
				aux.add(new Arista(v1, i));
				aux.add(new Arista(v2, i));
				
				aux.add(new Arista(v1, j));
				aux.add(new Arista(v2, j));
			}
    		
    		for(Arista a : aux) this.aristas.add(a);
			
    	}
		
	}

	public void eliminarArista(Arista arista) {
    	aristas.remove(arista);
    	arista.getVertice1().eliminarVecino(arista.getVertice2());
    	arista.getVertice2().eliminarVecino(arista.getVertice1());
    }
    
    public boolean existeArista(Arista arista) {
    	return this.aristas.contains(arista);
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
