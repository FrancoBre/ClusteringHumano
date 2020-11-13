package interfaz;

import java.util.ArrayList;

import logica.Arista;
import logica.Busqueda;
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
		
		for (int i = 0; i < this.getPersonas().size()-1; i++) {
			Vertice v1 = new Vertice(this.getPersonas().get(i));
			Vertice v2 = new Vertice(this.getPersonas().get(i+1));
		
			this.grafo.agregarArista(new Arista(v1, v2));
		}
		
		this.grafoCompleto = new GCompleto(this.grafo);
		
		this.agm = new AGM(this.grafoCompleto);
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
	
	public static void main(String[] args) {
		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
		Persona y = new Persona(3, 5, 5, 1, "vertice 4");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		
		GCompleto grafo = new GCompleto();
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		
		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		
		AGM agm = new AGM(grafo);
			
		Arista apm = Busqueda.aristaDePesoMaximo(agm);
		Vertice vg1 = apm.getVertice1();
		Vertice vg2 = apm.getVertice2();
		
		Busqueda.eliminarAristaDeMayorPeso(agm);
		
		System.out.println("\nArista de peso maximo=");
		System.out.println(vg1.getPersona().getNombre()+" - "+
				vg2.getPersona().getNombre()+"\n");
		
		ArrayList<Vertice> g1 = Busqueda.alcanzablesDesde(agm, vg1); 
		
		System.out.println("Grupo 1");
		for(Vertice v : g1) {
			System.out.println(v.getPersona().getNombre ());
		}
		
		ArrayList<Vertice> g2 = Busqueda.alcanzablesDesde(agm, vg2);
		
		System.out.println("\nGrupo 2");
		for(Vertice v : g2) {
			System.out.println(v.getPersona().getNombre());
		}
			
	}
	
}
