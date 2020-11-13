package logica;

import java.util.ArrayList;

//Clase que contiene dos grupos definidos de vertices
public class Cluster {
	
	public ArrayList<Vertice> grupo1;
	public ArrayList<Vertice> grupo2;
	
	public Cluster(AGM grafo) {
		
		Arista aEliminar = Busqueda.aristaDePesoMaximo(grafo);
		
		Vertice v1 = aEliminar.getVertice1();
		Vertice v2 = aEliminar.getVertice2();
			
		grafo.eliminarArista(aEliminar);
			
		this.grupo1 = (Busqueda.alcanzablesDesde(grafo, v1));
		this.grupo2 = (Busqueda.alcanzablesDesde(grafo, v2));
			
	}
	
	public ArrayList<Vertice> getGrupo1() {
		return this.grupo1;
	}

	public void setGrupo1(ArrayList<Vertice> grupo1) {
		this.grupo1 = grupo1;
	}

	public ArrayList<Vertice> getGrupo2() {
		return this.grupo2;
	}

	public void setGrupo2(ArrayList<Vertice> grupo2) {
		this.grupo2 = grupo2;
	}
}
