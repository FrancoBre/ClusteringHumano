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
//		ArrayList<Arista> aristas = new ArrayList<Arista>();
		
		for (int i = 0; i < this.getPersonas().size()-1; i++) {
			Vertice v1 = new Vertice(this.getPersonas().get(i));
			Vertice v2 = new Vertice(this.getPersonas().get(i+1));
							
//			System.out.println("Arista a ingresar");
//			System.out.println((new Arista(v1, v2)).getVertice1().getPersona().getNombre()
//					+" - "+(new Arista(v1, v2)).getVertice2().getPersona().getNombre());
			
			this.grafo.agregarArista(new Arista(v1, v2));
		}
		
//		System.out.println("\nAristas en grafo normal");
//		for(Arista a : this.grafo.getAristas()) {
//			System.out.println(a.getVertice1().getPersona().getNombre()
//					+" - "+a.getVertice2().getPersona().getNombre());
//		}
		
		this.grafoCompleto = new GCompleto(this.grafo);
		
		this.agm = new AGM(this.grafoCompleto);
//		System.out.println("\nAristas en grafo completo");
//		for(Arista a : this.grafoCompleto.getAristas()) {
//			System.out.println(a.getVertice1().getPersona().getNombre()
//					+" - "+a.getVertice2().getPersona().getNombre());
//		}
		
	}

	public void crearCluster() {
		this.cluster = new Cluster(agm);
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
	
}
