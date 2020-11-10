package logica;

import java.util.ArrayList;

//Grafo completo
public class GCompleto extends Grafo{
	
	private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;

    public GCompleto() {
    	this.vertices = new ArrayList<Vertice>();
    	this.aristas = new ArrayList<Arista>();
    }
	
	@Override
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
}
