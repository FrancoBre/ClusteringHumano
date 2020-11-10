package logica;

import java.util.ArrayList;

//Arbol generador minimo
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
		
		for(int i = 0 ; i < g.getVertices().size()-1 ; i++) {
			
			for(Arista a : g.getAristas()) {
				
				Arista nueva = new Arista
						(new Vertice(a.getVertice1().getPersona()),
						new Vertice(a.getVertice2().getPersona()));
				
				nueva.getVertice1().setVecinos(Busqueda.vecinosDe(this, a.getVertice1()));
				nueva.getVertice2().setVecinos(Busqueda.vecinosDe(this, a.getVertice2()));
				
				if(tienePesoMinimo(aux, a)) { 
					if(!Busqueda.formaCiclo(this, nueva)) {
						
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
	
}
