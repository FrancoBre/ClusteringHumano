package logica;

import java.util.ArrayList;

public class Vertice {
	
	private ArrayList<Vertice> vecinos;
	private Persona i;
	
	public Vertice(Persona persona) {
		this.vecinos = new ArrayList<Vertice>();
		this.i = persona;
	}
	
//	public Vertice(Persona persona, ArrayList<Vertice> vecinos) {
//		this.i = persona;
//		this.vecinos = vecinos;
//	}
 
	public void insertarVecino(Vertice vertice) {
		if(this.vecinos==null) System.out.println("vecinos es null");
		if(vertice==null) System.out.println("vecino es null");
		if(!this.vecinos.contains(vertice) && 
				!vertice.getPersona().equals(this.getPersona()))
			this.vecinos.add(vertice);
	}
	
	public boolean contiene(Vertice vertice) {
		return this.vecinos.contains(vertice);
	}
	
	public void eliminarVecino(Arista arista) {
		arista.getVertice1().vecinos.remove(arista.getVertice2());
		arista.getVertice2().vecinos.remove(arista.getVertice1());
	}
	
	public void eliminarVecino(Vertice vertice) {
		this.vecinos.remove(vertice);
	}
	
	public boolean tieneVecino(Vertice vertice) {
		return vertice.vecinos.isEmpty();
	}
	
	public ArrayList<Vertice> getVecinos() {
		return vecinos;
	}

	public void setVecinos(ArrayList<Vertice> vecinos) {
		this.vecinos = vecinos;
	}

	public Persona getPersona() {
		return i;
	}

	public void setI(Persona i) {
		this.i = i;
	}

	@Override
	public boolean equals(Object o) {
		Vertice vertice = (Vertice) o;
		
		return this.i.equals(vertice.getPersona());
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(i.toString()+"\nCon los vecinos: {");
		
		for(Vertice v : vecinos) 
			string.append(v.getPersona().toString()+"}\n");
			
		return string.toString();
		
	}	
}
