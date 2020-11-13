package logica;

import java.util.ArrayList;

import interfaz.Aplicacion;

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
	
	public static void main(String[] args) {
		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
		Persona y = new Persona(3, 5, 5, 1, "vertice 4");
		Persona z = new Persona(1, 3, 3, 1, "vertice 5");
		Persona w = new Persona(1, 5, 5, 1, "vertice 6");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		Vertice v5 = new Vertice(z);
		Vertice v6 = new Vertice(w);
		
		Aplicacion app = new Aplicacion();
		
		app.crearPersona(i);
		app.crearPersona(j);
		app.crearPersona(x);
		app.crearPersona(y);
		app.crearPersona(z);
		app.crearPersona(w);
		
		app.crearAristas();
		
		System.out.println("Aristas del grafo normal");
		for(Arista a : app.getGrafo().getAristas())
			System.out.println(a.getVertice1().getPersona().getNombre()+" - "+
					a.getVertice2().getPersona().getNombre());
			
		System.out.println("\nAristas del grafo completo");
		for(Arista a : app.getGrafoCompleto().getAristas())
			System.out.println(a.getVertice1().getPersona().getNombre()+" - "+
					a.getVertice2().getPersona().getNombre());
		
		System.out.println("\nAristas del AGM");
		AGM agm = new AGM(app.getGrafoCompleto());
		for(Arista a : agm.getAristas())
			System.out.println(a.getVertice1().getPersona().getNombre()+" - "+
					a.getVertice2().getPersona().getNombre());
		
		System.out.println("\nArista de mayor peso= \n"+
		Busqueda.aristaDePesoMaximo(agm).getVertice1().getPersona().getNombre()+" - "+
		Busqueda.aristaDePesoMaximo(agm).getVertice2().getPersona().getNombre());
		
		app.crearCluster();
		
		System.out.println("\nGrupos del cluster");
		System.out.println("Grupo 1");
		for(Vertice v : app.getGrupo1())
			System.out.println(v.getPersona().getNombre());
		
		System.out.println("\nGrupo 2");
		for(Vertice v : app.getGrupo2())
			System.out.println(v.getPersona().getNombre());
	}
}
