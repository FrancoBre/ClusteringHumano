package logica;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AGMTest {
	
	@Test
	public void agregarAristasAGMTest() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(4, 2, 5, 5);
		Persona x = new Persona(3, 1, 2, 4);
		Persona y = new Persona(3, 5, 5, 1);
		Persona z = new Persona(1, 3, 3, 1);
		
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
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(4, 2, 5, 5);
		Persona x = new Persona(3, 1, 2, 4);
		Persona y = new Persona(3, 5, 5, 1);
		Persona z = new Persona(1, 3, 3, 1);
			
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		Vertice v5 = new Vertice(z);
			
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		Arista a4 = new Arista(v4, v5);
		
		Grafo g = new Grafo();
			
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
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(1, 2, 1, 5);
		Persona x = new Persona(3, 1, 2, 4);
		Persona y = new Persona(3, 5, 5, 1);
		
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
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 5, 1, 4);
		Persona x = new Persona(1, 2, 1, 5);
		
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
	
}
