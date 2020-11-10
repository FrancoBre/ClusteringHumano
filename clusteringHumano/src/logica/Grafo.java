package logica;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;

    public Grafo() {
    	this.vertices = new ArrayList<Vertice>();
    	this.aristas = new ArrayList<Arista>();
    }
    
    public Grafo(ArrayList<Vertice> vertices, ArrayList<Arista> aristas) {
    	this.vertices = vertices;
    	this.aristas = aristas;
    }
    
    public void agregarArista(Arista arista) {
    	Arista alReves = new Arista(arista.getVertice2(), arista.getVertice1());
    	
    	if((!getAristas().contains(arista) || !getAristas().contains(alReves)) && 
    			!arista.getVertice1().equals(arista.getVertice2())) {	
    		
    		getAristas().add(arista);
    		
    		if(!getVertices().contains(arista.getVertice1())) 
    			getVertices().add(arista.getVertice1());

    		
    		if(!getVertices().contains(arista.getVertice2())) 
    			getVertices().add(arista.getVertice2());
    		
    		aristasGrafoCompleto(arista);
    	}
    	
    }
    
    private void aristasGrafoCompleto(Arista arista) {
	    if(this.getAristas().size() >= 2) {
	    	ArrayList<Arista> aux = new ArrayList<Arista>();
	    	
    		for(Arista a : this.getAristas()) {
				Vertice i = a.getVertice1();
				Vertice j = a.getVertice2();
				
				Vertice v1 = arista.getVertice1();
				Vertice v2 = arista.getVertice2();
			
				aux.add(new Arista(v1, i));
				aux.add(new Arista(v2, i));
				
				aux.add(new Arista(v1, j));
				aux.add(new Arista(v2, j));
			}
    		
    		for(Arista a : aux) {
    			Arista alReves = new Arista(a.getVertice2(), a.getVertice1());
    			
    	    	if((!getAristas().contains(a) || !getAristas().contains(alReves)) && 
    	    			!a.getVertice1().equals(a.getVertice2())) {
    	    	
	    			this.getAristas().add(a);
	    			
	    			if(!getVertices().contains(arista.getVertice1())) 
	        			getVertices().add(arista.getVertice1());
	        		
	        		if(!getVertices().contains(arista.getVertice2())) 
	        			getVertices().add(arista.getVertice2());

    	    	}
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
	
	public Grafo getClone() {
		return new Grafo(this.vertices, this.aristas);
	}

}