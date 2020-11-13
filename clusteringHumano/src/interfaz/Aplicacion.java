package interfaz;

import java.util.ArrayList;

import logica.Arista;
import logica.Cluster;
import logica.GCompleto;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;
import logica.AGM;

public class Aplicacion {

	private ArrayList<Persona> personas;
	private Grafo grafo;
	private GCompleto grafoCompleto;
	private AGM agm;
	private Cluster cluster;
	private ArrayList<Vertice> grupo1;
	private ArrayList<Vertice> grupo2;

	public Aplicacion() {
		this.personas = new ArrayList<Persona>();
		this.grafo = new Grafo();
	}
	
	public void crearPersona(Persona persona) {
		this.personas.add(persona);
	}
	
	public void crearAristas() {
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		
		for (int i = 0; i < this.getPersonas().size()-1; i++) {
			Vertice v1 = new Vertice(this.getPersonas().get(i));
			Vertice v2 = new Vertice(this.getPersonas().get(i+1));
							
			System.out.println("Arista a ingresar");
			System.out.println((new Arista(v1, v2)).getVertice1().getPersona().getNombre()
					+" - "+(new Arista(v1, v2)).getVertice2().getPersona().getNombre());
			aristas.add(new Arista(v1, v2));
		}
		
		System.out.println("\nAristas en arraylist aristas");
		for(Arista a : aristas) {
			this.grafo.agregarArista(a);
			System.out.println(a.getVertice1().getPersona().getNombre()
					+" - "+a.getVertice2().getPersona().getNombre());
		}
		
		this.grafoCompleto = new GCompleto();
		
		for(Arista a : this.grafo.getAristas())
			this.grafoCompleto.agregarArista(a);
			
		this.crearCluster();
		
	}

	private void crearCluster() {
		this.cluster = new Cluster(grafoCompleto);
		this.grupo1 = cluster.getGrupo1();
		this.grupo2 = cluster.getGrupo2();
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

	public AGM getAgm() {
		return agm;
	}

	public void setAgm(AGM agm) {
		this.agm = agm;
	}
	
	public GCompleto getGrafoCompleto() {
		return grafoCompleto;
	}

	public void setGrafoCompleto(GCompleto grafoCompleto) {
		this.grafoCompleto = grafoCompleto;
	}
	
	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

	public static void main(String[] args) {
		Aplicacion aplicacion = new Aplicacion();

		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
		Persona y = new Persona(3, 5, 5, 1, "vertice 4");
		Persona z = new Persona(1, 3, 3, 1, "vertice 5");
		
		aplicacion.crearPersona(i);
		aplicacion.crearPersona(j);
		aplicacion.crearPersona(x);
		aplicacion.crearPersona(y);
		aplicacion.crearPersona(z);
		
		aplicacion.crearAristas();
		
		System.out.println(aplicacion.getGrafo().getAristas().isEmpty()+"\n");
		
		for(Arista a : aplicacion.getGrafoCompleto().getAristas())	
			System.out.println(a.getVertice1().getPersona().getNombre()+" - "+
					a.getVertice2().getPersona().getNombre());
	}
	
}
