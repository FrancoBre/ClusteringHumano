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
    	
    	if((!aristas.contains(arista) || !aristas.contains(alReves)) && 
    			!arista.getVertice1().equals(arista.getVertice2())) {	
    		
    		aristas.add(arista);
    		
    		if(!vertices.contains(arista.getVertice1())) 
    			vertices.add(arista.getVertice1());
    		else 
    			this.vertices.get(this.vertices.indexOf(arista.getVertice1()))
    			.insertarVecino(arista.getVertice2());
    		
    		
    		if(!vertices.contains(arista.getVertice2())) 
    			vertices.add(arista.getVertice2());
    		else 
    			this.vertices.get(this.vertices.indexOf(arista.getVertice2()))
    			.insertarVecino(arista.getVertice1());
    		
    		aristasGrafoCompleto(arista);
    	}
    	
    }
    
    private void aristasGrafoCompleto(Arista arista) {
	    if(this.aristas.size() >= 2) {
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
    		
    		for(Arista a : aux) {
    			Arista alReves = new Arista(a.getVertice2(), a.getVertice1());
    			
    	    	if((!aristas.contains(a) || !aristas.contains(alReves)) && 
    	    			!a.getVertice1().equals(a.getVertice2())) {
    	    	
	    			this.aristas.add(a);
	    			
	    			if(!vertices.contains(arista.getVertice1())) 
	        			vertices.add(arista.getVertice1());
	        		else 
	        			this.vertices.get(this.vertices.indexOf(arista.getVertice1()))
	        			.insertarVecino(arista.getVertice2());
	        		
	        		
	        		if(!vertices.contains(arista.getVertice2())) 
	        			vertices.add(arista.getVertice2());
	        		else 
	        			this.vertices.get(this.vertices.indexOf(arista.getVertice2()))
	        			.insertarVecino(arista.getVertice1());
    	    	}
    		}
			
    	}
		
	}

	public void eliminarArista(Arista arista) {
    	aristas.remove(arista);
    	arista.getVertice1().eliminarVecino(arista.getVertice2());
    	arista.getVertice2().eliminarVecino(arista.getVertice1());
    }
    
    public boolean existeArista(Arista arista) {
		Arista alReves = new Arista(arista.getVertice2(), arista.getVertice1());
    	return this.aristas.contains(arista) || this.aristas.contains(alReves);
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
