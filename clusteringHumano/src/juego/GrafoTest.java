package juego;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class GrafoTest {

//	@Before		NO SE COMO SE USA ESTO
//	public void initialize() {
//		Persona i = new Persona(1, 2, 1, 5);
//		Persona j = new Persona(3, 3, 2, 4);
//		Vertice v1 = new Vertice(i);
//		Vertice v2 = new Vertice(j);
//		Arista a = new Arista(v1, v2);
//	}
	
	@Test
	public void insercionDeVecinosTest() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		
		assertTrue(a.getVertice1().getVecinos().contains(a.getVertice2()));
		
	}
	
	@Test
	public void eliminarVecinosTest() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		
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
	public void eliminarAristaTest() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
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
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
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
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
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
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		Grafo g = new Grafo();
		
		g.agregarArista(a);
		
		assertTrue(g.existeArista(a));
		
	}
	
	@Test
	public void indiceDeSimilaridadTest() {
		Persona i = new Persona(3, 2, 3, 5);
		Persona j = new Persona(1, 4, 4, 2);
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Arista a = new Arista(v1, v2);
		assertEquals(8, a.getPeso());
	}
	
	@Test
	public void crearGrafoCompletoTest() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		Persona x = new Persona(5, 5, 1, 3);
		Persona y = new Persona(5, 1, 2, 2);
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		Grafo grafo = new Grafo();
		
		grafo.agregarArista(a);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		
		Arista a4 = new Arista(v4, v1);
		Arista a5 = new Arista(v3, v1);
		Arista a6 = new Arista(v4, v2);
		
		assertTrue(grafo.getAristas().contains(a4));
		assertTrue(grafo.getAristas().contains(a5));
		assertTrue(grafo.getAristas().contains(a6));
	
	}
	
	@Test
	public void aristasIgualesTest() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);

		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);

		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v1);
		
		assertTrue(a.equals(a2));
	}
	
	@Test
	public void aristasDesigualesTest() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		Persona x = new Persona(5, 5, 1, 3);

		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);

		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		
		assertFalse(a.equals(a2));
	}
	
	/*
	@Test
	public void crearGrafoConAristasTest() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		Persona x = new Persona(5, 5, 1, 3);
		Persona y = new Persona(5, 1, 2, 2);
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		Arista a = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		aristas.add(a);
		aristas.add(a2);
		Grafo g = new Grafo(aristas);
		
		assertTrue(g.existeArista(a));
		assertTrue(g.existeArista(a2));
		
		g.agregarArista(a3);
		
		assertTrue(g.existeArista(a3));
		
	}*/
	
}
