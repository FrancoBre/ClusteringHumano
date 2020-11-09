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
		
		ArrayList<Arista> aux = g.getAristas();
		
		for(int i = 0 ; i < g.getAristas().size()-1 ; i++) {

			for(Arista a : g.getAristas()) {
				
				if(tienePesoMinimo(aux, a)) { 
					if(!Busqueda.formaCiclo(this, a)) {
						
						Arista nueva = new Arista(new Vertice(a.getVertice1().getPersona()),
								new Vertice(a.getVertice2().getPersona()));
						
						this.agregarArista(nueva);
						aux.remove(a);

						break;
						
					}else {
						aux.remove(a);
						i--;
						
						break;
					}
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
	
	//No relaciona a todos con todos como en la clase Grafo, que crea un grafo completo
	@Override
	public void agregarArista(Arista arista) {
		Arista alReves = new Arista(arista.getVertice2(), arista.getVertice1());
    	
    	if((!this.getAristas().contains(arista) || !this.getAristas().contains(alReves)) && 
    			!arista.getVertice1().equals(arista.getVertice2())) {	
	    		
    		this.getAristas().add(arista);
	    	 
    		if(!this.getVertices().contains(arista.getVertice1()))
    			this.getVertices().add(arista.getVertice1());
    		else 
    			this.getVertices().get(this.getVertices().indexOf(arista.getVertice1()))
    			.insertarVecino(arista.getVertice2());
    		
    		if(!this.getVertices().contains(arista.getVertice2()))
    			this.getVertices().add(arista.getVertice2());
    		else 
    			this.getVertices().get(this.getVertices().indexOf(arista.getVertice2()))
    			.insertarVecino(arista.getVertice1());
    		
    	}
	}
}