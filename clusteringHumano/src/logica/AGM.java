package logica;

import java.util.ArrayList;

public class AGM extends Grafo{
	
	private ArrayList<Arista> aristas;
	private ArrayList<Vertice> vertices;
	
	public AGM() {
		this.vertices = new ArrayList<Vertice>();
    	this.aristas = new ArrayList<Arista>();
	}
	
	public AGM(Grafo g) {
		this.vertices = new ArrayList<Vertice>();
    	this.aristas = new ArrayList<Arista>();
    	
    	crearAGM(g);
	}
	
	//Kruskal
	public void crearAGM(Grafo g) {
		ArrayList<Arista> eT = g.getAristas();
		
		for(int i = 0 ; i < eT.size()-1 ; i++) {
			
			for(Arista a : g.getAristas()) {
				
				if(tienePesoMinimo(eT, a) &&
					!aristas.contains(a) &&
					!formaCiclo(g, a)) {
					
					this.agregarArista(a);
					eT.remove(a);
					
				}
			}
		}
	}
	
	public boolean tienePesoMinimo(ArrayList<Arista> aristas, Arista arista) {
		Arista min = aristas.get(0);
		
		for(Arista a : aristas) 
			if(a.getPeso() < min.getPeso()) min = a;
		
		return min.equals(arista);
	}
	
	//Devuelve si el segundo vertice de la arista es alcanzable a partir del primer vertice
	//caso para el cual el grafo con esa arista formaria ciclo
	public boolean formaCiclo(Grafo grafo, Arista arista) {
		return(Busqueda.alcanzablesDesde(grafo, arista.getVertice1()).
				contains(arista.getVertice2()))?true:false;
	}
	
	@Override
	public void agregarArista(Arista arista) {
		Arista alReves = new Arista(arista.getVertice2(), arista.getVertice1());
    	
    	if((!aristas.contains(arista) || !aristas.contains(alReves)) && 
    			!arista.getVertice1().equals(arista.getVertice2())) {	
	    		
    		this.getAristas().add(arista);
	    	
    		if(!this.getVertices().contains(arista.getVertice1())) 
    			vertices.add(arista.getVertice1());
    		if(!this.getVertices().contains(arista.getVertice2())) 
    			vertices.add(arista.getVertice2());
    	
    	}
	}
}