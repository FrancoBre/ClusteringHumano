package juego;

import java.util.ArrayList;

import interfaz.Juego;

public class Grafo {
	private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;

    public Grafo() {
    	this.vertices = new ArrayList<Vertice>();
    	this.aristas = new ArrayList<Arista>();
    }
    
    public void agregarArista(Arista arista) {
    	Arista alReves = new Arista(arista.getVertice2(), arista.getVertice1());
    	
    	if(!aristas.contains(arista) || !aristas.contains(alReves) || 
    			arista.getVertice1().equals(arista.getVertice2())) {	
    		
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
    		
    		for(Arista a : aux) {
    			Arista alReves = new Arista(a.getVertice2(), a.getVertice1());
    			
    	    	if(!aristas.contains(a) || !aristas.contains(alReves)) {
    	    		
    	    		vertices.add(a.getVertice1());
    	    		vertices.add(a.getVertice2());
	    			this.aristas.add(a);
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
	
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		Persona persona = new Persona(3, 2, 3, 5, "Juan Carlos Pachorra");
		Persona persona2 = new Persona(1, 4, 4, 2, "Horacio Gómez");
		Persona persona3 = new Persona(5, 1, 1, 2, "Pedro Arrizabalaga");
		Persona persona4 = new Persona(5, 2, 5, 5, "Natalia Furtado");
		Vertice v1 = new Vertice(persona);
		Vertice v2 = new Vertice(persona2);
		Vertice v3 = new Vertice(persona3);
		Vertice v4 = new Vertice(persona4);
		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		
		grafo.agregarArista(a);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		
		for (int i = 0; i < grafo.getAristas().size(); i++) {
			System.out.println(grafo.getAristas().get(i).toString());
		}	

	}
	
}
