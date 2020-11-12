package interfaz;

import java.util.ArrayList;

import logica.Arista;
import logica.Cluster;
import logica.GCompleto;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;

public class Aplicacion {

	private ArrayList<Persona> personas;
	private Grafo grafo;
	private Cluster cluster;
	private ArrayList<Vertice> grupo1;
	private ArrayList<Vertice> grupo2;

	public Aplicacion() {
		this.grafo = new GCompleto();
		this.personas = new ArrayList<Persona>();
	}
	
	public void crearPersona(Persona persona) {
		this.personas.add(persona);
		crearAristas();
	}
	
	private void crearAristas() {
		if(personas.size()>=2) {
			Vertice v1 = new Vertice(personas.get(personas.size()-1));
			Vertice v2 = new Vertice(personas.get(personas.size()-2));
			Arista arista = new Arista(v1, v2);
			
			this.grafo.agregarArista(arista);
		}
	}
	
	public void crearCluster() {
		this.cluster = new Cluster(grafo);
		this.grupo1 = this.cluster.getGrupo1();
		this.grupo2 = this.cluster.getGrupo2();
	}
	
	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public ArrayList<Vertice> getGrupo1() {
		return grupo1;
	}

	public void setGrupo1(ArrayList<Vertice> grupo1) {
		this.grupo1 = grupo1;
	}

	public ArrayList<Vertice> getGrupo2() {
		return grupo2;
	}

	public void setGrupo2(ArrayList<Vertice> grupo2) {
		this.grupo2 = grupo2;
	}
	

}
