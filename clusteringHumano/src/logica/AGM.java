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
		
		for(int i = 0 ; i < g.getVertices().size()-1 ; i++) {
			
			System.out.println("ITERACION NUMERO "+(i+1));
			
			for(Arista a : g.getAristas()) {
				
				System.out.println();
				System.out.println("\nArista= "+a.getVertice1().getPersona().getNombre()
						+" - "+a.getVertice2().getPersona().getNombre());
				System.out.println("Tiene peso= "+a.getPeso());
				System.out.println("Es minimo= "+tienePesoMinimo(aux, a));
				System.out.println("Forma ciclo= "+Busqueda.formaCiclo(this, a));
				
				Arista nueva = new Arista
						(new Vertice(a.getVertice1().getPersona()),
						new Vertice(a.getVertice2().getPersona()));
				
				nueva.getVertice1().setVecinos(Busqueda.vecinosDe(this, a.getVertice1()));
				nueva.getVertice2().setVecinos(Busqueda.vecinosDe(this, a.getVertice2()));
				
				if(tienePesoMinimo(aux, a)) { 
					if(!Busqueda.formaCiclo(this, nueva)) {
						
						this.agregarArista(nueva);
						aux.remove(a);
						
						System.out.println("\nCumple la guarda"+"\nArista= "+nueva.getVertice1().getPersona().getNombre()
						+" - "+nueva.getVertice2().getPersona().getNombre()+"\n");
						
						System.out.println();
						
						System.out.println("ESTADO DEL GRAFO=" );
						System.out.println("Cantidad de aristas= "+this.getAristas().size());
						for(Arista a1 : this.getAristas()) System.out.println(a1.getVertice1().getPersona().getNombre()+" - "+
								a1.getVertice2().getPersona().getNombre());
						System.out.println("Cantidad de vertices="+this.getVertices().size());
						for(Vertice v1 : this.getVertices()) System.out.println(v1.getPersona().getNombre());
						
						for(Vertice v : this.getVertices()) {
							System.out.println("\nVecinos del "+v.getPersona().getNombre());
							for(Vertice v1 : v.getVecinos()) 
								System.out.println(v1.getPersona().getNombre());
						}
						
						System.out.println("\n########################################\n");
						
						break;
						
					}else {
						aux.remove(a);
						i--;
						System.out.println("\nNo cumple la guarda y se elimina"+
								"\nArista= "+nueva.getVertice1().getPersona().getNombre()
								+" - "+nueva.getVertice2().getPersona().getNombre()+"\n");
						
						System.out.println("ESTADO DEL GRAFO=" );
						System.out.println("Cantidad de aristas= "+this.getAristas().size());
						for(Arista a1 : this.getAristas()) System.out.println(a1.getVertice1().getPersona().getNombre()+" - "+
								a1.getVertice2().getPersona().getNombre());
						System.out.println("Cantidad de vertices="+this.getVertices().size());
						for(Vertice v1 : this.getVertices()) System.out.println(v1.getPersona().getNombre());
						
						for(Vertice v : this.getVertices()) {
							System.out.println("\nVecinos del "+v.getPersona().getNombre());
							for(Vertice v1 : v.getVecinos()) 
								System.out.println(v1.getPersona().getNombre());
						}
						
						System.out.println("########################################\n");
						
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
	    	 
    		if(!this.getVertices().contains(arista.getVertice1())) {
    			this.getVertices().add(arista.getVertice1());
    		}
    		
    		if(!this.getVertices().contains(arista.getVertice2())) {
    			this.getVertices().add(arista.getVertice2());
    		}
    		
    	}
	}
	
	public static void main(String[] args) {
		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
		Persona y = new Persona(3, 5, 5, 1, "vertice 4");
		Persona z = new Persona(1, 3, 3, 1, "vertice 5");
			
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		Vertice v5 = new Vertice(z);
			
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		Arista a4 = new Arista(v4, v5);
		
		Grafo g = new Grafo();
			
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		g.agregarArista(a4);
//		
//		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
//		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
//		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
//			
//		Vertice v1 = new Vertice(i);
//		Vertice v2 = new Vertice(j);
//		Vertice v3 = new Vertice(x);
//			
//		Arista a2 = new Arista(v1, v2);
//		Arista a3 = new Arista(v2, v3);
//		
//		Grafo g = new Grafo();
//			
//		g.agregarArista(a2);
//		g.agregarArista(a3);
//		
		AGM agm = new AGM(g);
		
		for(Arista a : agm.getAristas())
			System.out.println(a.getVertice1().getPersona().getNombre()+" - "+a.getVertice2().getPersona().getNombre());
		
		System.out.println("\n"+Busqueda.esConexo(agm));
	}
	
}