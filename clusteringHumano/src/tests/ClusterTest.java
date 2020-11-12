package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import interfaz.Aplicacion;
import logica.AGM;
import logica.Arista;
import logica.Cluster;
import logica.GCompleto;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;

class ClusterTest {
	
	@Test
	public void componentesConexasTest1() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 5, 1, 1, "");
		Persona x = new Persona(1, 2, 1, 4, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		
		AGM agm = new AGM(g);
	
		Cluster cluster = new Cluster(agm); 
		
		ArrayList<Vertice> c1 = cluster.getGrupo1();
		ArrayList<Vertice> c2 = cluster.getGrupo2() ;
		 
		assertTrue(c1.contains(v1)); 
		assertTrue(c2.contains(v3)); 
		assertTrue(c2.contains(v3));
		
		assertFalse(c1.contains(v2));
		assertFalse(c1.contains(v3));
	}
	
	@Test
	public void componentesConexasTest2() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(4, 2, 5, 5, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		Persona y = new Persona(3, 5, 5, 1, "");
		Persona z = new Persona(1, 3, 3, 1, "");
			
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		Vertice v5 = new Vertice(z);
			
		Arista a1 = new Arista(v1, v3);
		Arista a2 = new Arista(v3, v2);
		Arista a3 = new Arista(v4, v5);
		Arista a4 = new Arista(v5, v1);
		
		Grafo g = new Grafo();
			
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		g.agregarArista(a4);
		
		AGM agm = new AGM(g);
	
		Cluster cluster = new Cluster(agm); 
		
		ArrayList<Vertice> c1 = cluster.getGrupo1();
		ArrayList<Vertice> c2 = cluster.getGrupo2();
		 
		assertTrue(c1.contains(v5));
		assertTrue(c1.contains(v4));
		assertTrue(c2.contains(v1));
		assertTrue(c2.contains(v3));
		assertTrue(c2.contains(v2));
		
		assertFalse(c1.contains(v1));
		assertFalse(c1.contains(v3));
		assertFalse(c1.contains(v2));
		assertFalse(c2.contains(v5));
		assertFalse(c2.contains(v4));
	}
	
	@Test
	public void ClustersTest() {
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
		
		Grafo g = new GCompleto();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		g.agregarArista(a4);
		
		AGM agm = new AGM(g);
		
		Cluster cluster = new Cluster(agm);
		
		ArrayList<Vertice> c1 = cluster.getGrupo1();
		ArrayList<Vertice> c2 = cluster.getGrupo2();
		
		assertTrue(c1.contains(v5));
		assertTrue(c1.contains(v4));
		assertTrue(c2.contains(v1));
		assertTrue(c2.contains(v3));
		assertTrue(c2.contains(v2));
		
		assertFalse(c2.contains(v5));
		assertFalse(c2.contains(v4));
		assertFalse(c1.contains(v1));
		assertFalse(c1.contains(v3));
		assertFalse(c1.contains(v2));
	}
	
	@Test
	public void clusterTest2() {
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
		
		Grafo g = new GCompleto();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		g.agregarArista(a4);
		
		AGM agm = new AGM(g);
		
		Cluster cluster = new Cluster(agm);
		
		assertFalse(cluster.getGrupo2().contains(v4) && 
				cluster.getGrupo2().contains(v2));
		
		assertFalse(cluster.getGrupo1().contains(v3) && 
				cluster.getGrupo1().contains(v4) &&
				cluster.getGrupo1().contains(v2));
	}
	
	@Test
	public void clusterTest3() {
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
		app.crearCluster();
		
		assertTrue(app.getGrupo1().contains(v5));
//		assertTrue(app.getGrupo1().contains(v4));
//		assertTrue(app.getGrupo1().contains(v6));
		
		assertTrue(app.getGrupo2().contains(v1));
		assertTrue(app.getGrupo1().contains(v2));
		assertTrue(app.getGrupo1().contains(v3));
		
	}
	
}
