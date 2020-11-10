package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import logica.AGM;
import logica.Arista;
import logica.GCompleto;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;

class AGMTest {
	
	@Test
	public void agregarAristasAGMTest() {
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
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		Arista a4 = new Arista(v4, v5);
		
		AGM agm = new AGM();
		
		agm.agregarArista(a1);
		agm.agregarArista(a2);
		agm.agregarArista(a3);
		agm.agregarArista(a4);
		
		assertTrue(agm.existeArista(a1));
		assertTrue(agm.existeArista(a2));
		assertTrue(agm.existeArista(a3));
		assertTrue(agm.existeArista(a4));
	}
	
	@Test
	public void agregarAristasAGMTest2() {
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
		
		Grafo g = new AGM();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		g.agregarArista(a4);
		
		assertTrue(g.existeArista(a1));
		assertTrue(g.existeArista(a2));
		assertTrue(g.existeArista(a3));
		assertTrue(g.existeArista(a4));
	}
	
	@Test
	public void crearAGMTest() {
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
			
		Arista agmA1 = new Arista(v3, v1);

		Arista agmA2 = new Arista(v2, v3);

		Arista agmA3 = new Arista(v4, v5);
		
		Arista agmA4 = new Arista(v5, v1);
			
		assertTrue(agm.existeArista(agmA1));
		assertTrue(agm.existeArista(agmA2));
		assertTrue(agm.existeArista(agmA3));
		assertTrue(agm.existeArista(agmA4));

		Arista a5 = new Arista(v1, v4);
		Arista a6 = new Arista(v4, v2);
			
		assertFalse(agm.existeArista(a1));
		assertFalse(agm.existeArista(a3));
		assertFalse(agm.existeArista(a5));
		assertFalse(agm.existeArista(a6));
	}
	
	@Test
	public void tienePesoMinimoTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(1, 2, 1, 5, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		Persona y = new Persona(3, 5, 5, 1, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		
		aristas.add(a1);
		aristas.add(a2);
		aristas.add(a3);
		
		AGM agm = new AGM();
		
		assertTrue(agm.tienePesoMinimo(aristas, a1));
		
	}
	
	@Test
	public void noTienePesoMinimoTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 5, 1, 4, "");
		Persona x = new Persona(1, 2, 1, 5, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v1, v3);
		
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		
		aristas.add(a1);
		aristas.add(a2);
		aristas.add(a3);
		
		AGM agm = new AGM();
		
		assertFalse(agm.tienePesoMinimo(aristas, a1));
	}
	
	@Test 
	public void creacionVecinosEnAGMTest1() {
		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
			
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);

		Arista a1 = new Arista(v1, v3);
		Arista a2 = new Arista(v3, v2);
		
		AGM g = new AGM();
			
		g.agregarArista(a1);
		g.agregarArista(a2);
		
		assertTrue(v3.getVecinos().contains(v1));
		assertTrue(v3.getVecinos().contains(v2));
		assertTrue(v1.getVecinos().contains(v3));
		assertFalse(v1.getVecinos().contains(v2));
	}
	
	@Test
	public void creacionVecinosEnAGMTest2() {
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
			
		Arista a2 = new Arista(v1, v3);
		Arista a3 = new Arista(v2, v3);
		Arista a4 = new Arista(v4, v5);
		
		AGM g = new AGM();
			
		g.agregarArista(a2);
		g.agregarArista(a3);
		g.agregarArista(a4);
		
		assertFalse(v1.getVecinos().contains(v4));
		assertFalse(v2.getVecinos().contains(v4));
		assertFalse(v3.getVecinos().contains(v4));
	}
	
	@Test
	public void creacionDeVecinosEnAGMAPartirDeGrafoTest1() {
		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
			
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
			
		Arista a2 = new Arista(v1, v2);
		Arista a3 = new Arista(v2, v3);
		
		Grafo g = new GCompleto();
			
		g.agregarArista(a2);
		g.agregarArista(a3);
		
		AGM agm = new AGM(g);
		
		assertTrue(agm.getVertices().contains(v1));
		assertTrue(agm.getVertices().contains(v2));
		assertTrue(agm.getVertices().contains(v3));
		
		Vertice agmV1 = agm.getVertices().get(agm.getVertices().indexOf(v1));
		Vertice agmV2 = agm.getVertices().get(agm.getVertices().indexOf(v2));
		Vertice agmV3 = agm.getVertices().get(agm.getVertices().indexOf(v3));
		
		assertTrue(agmV1.getVecinos().contains(agmV3));
		assertFalse(agmV1.getVecinos().contains(agmV2));
	}
	
	@Test
	public void creacionDeVecinosEnAGMAPartirDeGrafoTest2() {
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
			
		Arista a2 = new Arista(v1, v2);
		Arista a3 = new Arista(v2, v3);
		Arista a4 = new Arista(v3, v4);
		Arista a5 = new Arista(v4, v5);
		
		Grafo g = new GCompleto();
			
		g.agregarArista(a2);
		g.agregarArista(a3);
		g.agregarArista(a4);
		g.agregarArista(a5);
		
		AGM agm = new AGM(g);
		
		assertTrue(agm.getVertices().contains(v1));
		assertTrue(agm.getVertices().contains(v2));
		assertTrue(agm.getVertices().contains(v3));
		assertTrue(agm.getVertices().contains(v4));
		assertTrue(agm.getVertices().contains(v5));
		
		Vertice agmV1 = agm.getVertices().get(agm.getVertices().indexOf(v1));
		Vertice agmV2 = agm.getVertices().get(agm.getVertices().indexOf(v2));
		Vertice agmV3 = agm.getVertices().get(agm.getVertices().indexOf(v3));
		Vertice agmV4 = agm.getVertices().get(agm.getVertices().indexOf(v4));
		Vertice agmV5 = agm.getVertices().get(agm.getVertices().indexOf(v5));
		
		assertTrue(agmV1.getVecinos().contains(agmV5));
		assertTrue(agmV1.getVecinos().contains(agmV3));
		assertTrue(agmV2.getVecinos().contains(agmV3));
		assertTrue(agmV3.getVecinos().contains(agmV1));
		assertTrue(agmV3.getVecinos().contains(agmV2));
		assertTrue(agmV4.getVecinos().contains(agmV5));
		assertTrue(agmV5.getVecinos().contains(agmV4));
		assertTrue(agmV5.getVecinos().contains(agmV1));
		
		assertFalse(agmV1.getVecinos().contains(agmV2));
		assertFalse(agmV1.getVecinos().contains(agmV4));
		
	}
	
}