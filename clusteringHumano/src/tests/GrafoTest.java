package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logica.Arista;
import logica.GCompleto;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;

class GrafoTest {
	
	@Test
	public void insercionDeVecinosTest1() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		
		assertTrue(a.getVertice1().getVecinos().contains(a.getVertice2()));
		
	}
	
	@Test
	public void insercionDeVecinosTest2() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Persona y = new Persona(2, 1, 1, 1, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(y);
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Grafo g = new GCompleto();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		
		assertTrue(v1.getVecinos().contains(v2));
		assertTrue(v1.getVecinos().contains(v3));
	}
	
	@Test
	public void eliminarVecinosTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		
		v1.insertarVecino(v2);
		v2.insertarVecino(v1);
		
		assertTrue(v1.getVecinos().contains(v2));
		assertTrue(v2.getVecinos().contains(v1));
		
		v1.eliminarVecino(v2);
		v2.eliminarVecino(v1);
		
		assertTrue(!v1.getVecinos().contains(v2));
		assertTrue(!v2.getVecinos().contains(v1));
		
	}
	
	@Test
	public void vecinosIlegalesTest() {
		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
			
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
			
		Arista a2 = new Arista(v1, v2);
		Arista a3 = new Arista(v2, v3);
		
		Grafo g = new Grafo();
			
		g.agregarArista(a2);
		g.agregarArista(a3);
		
		assertFalse(v1.getVecinos().contains(v1));
		assertFalse(v2.getVecinos().contains(v2));
		assertFalse(v3.getVecinos().contains(v3));
	}
	
	@Test
	public void eliminarAristaTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		Grafo g = new Grafo();
		
		g.agregarArista(a);
		
		g.eliminarArista(a);
		
		assertTrue(!a.getVertice1().getVecinos().contains(v2));
		assertTrue(!a.getVertice2().getVecinos().contains(v1));
	}
	
	@Test
	public void agregarAristaTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		Grafo g = new Grafo();
		
		g.agregarArista(a);
		
		assertTrue(g.getVertices().contains(v1));
		assertTrue(g.getVertices().contains(v2));
		assertTrue(g.getAristas().contains(a));
		
		assertTrue(a.getVertice1().getVecinos().contains(v2));
		assertTrue(a.getVertice2().getVecinos().contains(v1));
		
	}
	
	@Test
	public void eliminarAristaIlegalTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		Grafo g = new Grafo();
		
		g.agregarArista(a);
		g.eliminarArista(a);
		
		assertTrue(!g.existeArista(a));
		
	}
	
	@Test
	public void existeAristaTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		Grafo g = new Grafo();
		
		g.agregarArista(a);
		
		assertTrue(g.existeArista(a));
		
	}
	
	@Test
	public void indiceDeSimilaridadTest2() {
		Persona i = new Persona(3, 2, 3, 5, "");
		Persona j = new Persona(1, 4, 4, 2, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		assertEquals(8, a.getPeso());
	}
	
	@Test
	public void crearGrafoCompletoTest1() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Persona x = new Persona(5, 5, 1, 3, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Grafo grafo = new GCompleto();
		
		grafo.agregarArista(a);
		grafo.agregarArista(a2);
		
		Arista a4 = new Arista(v1, v3);
		
		assertTrue(grafo.getAristas().contains(a4));

	}
	
	@Test
	public void crearGrafoCompletoTest2() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Persona x = new Persona(5, 5, 1, 3, "");
		Persona y = new Persona(5, 1, 2, 2, "");
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		Grafo grafo = new GCompleto();
		
		grafo.agregarArista(a);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		
		Arista a4 = new Arista(v4, v1);
		Arista a5 = new Arista(v3, v1);
		Arista a6 = new Arista(v4, v2);
		Arista a7 = new Arista(v3, v3);
		
		assertTrue(grafo.getAristas().contains(a4));
		assertTrue(grafo.getAristas().contains(a5));
		assertTrue(grafo.getAristas().contains(a6));
		assertFalse(grafo.getAristas().contains(a7));
	
	}
	
	@Test
	public void aristasIgualesTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");

		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);

		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v1);
		
		assertTrue(a.equals(a2));
	}
	
	@Test
	public void aristasDesigualesTest() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Persona x = new Persona(5, 5, 1, 3, "");

		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);

		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		
		assertFalse(a.equals(a2));
	}
	
}
