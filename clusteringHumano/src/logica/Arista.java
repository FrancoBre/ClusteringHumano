package logica;

public class Arista {
	
	private Vertice vertice1, vertice2;
	private int peso;
	 public Arista(Vertice vertice1, Vertice vertice2, int peso){
		this.vertice1=vertice1;
		this.vertice2=vertice2;
		this.peso=peso;
	 }
	
	public Arista(Vertice vertice1, Vertice vertice2){
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.peso = vertice1.getPersona().indiceDeSimilaridad(vertice2.getPersona());
		if(vertice2!=null) vertice1.insertarVecino(vertice2);
		if(vertice1!=null) vertice2.insertarVecino(vertice1);
	}

	public Vertice getVertice1() {
		return vertice1;
	}

	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}

	public Vertice getVertice2() {
		return vertice2;
	}

	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public boolean equals(Object o) {
		Arista arista = (Arista) o;
		
		if((this.vertice1.equals(arista.getVertice1()) &&
				this.vertice2.equals(arista.getVertice2()) &&
				this.peso==arista.getPeso()) || 
				(this.vertice2.equals(arista.getVertice1()) &&
				this.vertice1.equals(arista.getVertice2()) &&
				this.peso==arista.getPeso()))
			return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return "Arista con peso "+peso+"\n\nVertice 1=\n"+this.vertice1.toString()+"\nVertice 2= \n"
					+this.vertice2.toString();
	}
	
}
