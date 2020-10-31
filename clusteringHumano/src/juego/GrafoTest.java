package juego;

import static org.junit.jupiter.api.Assertions.*;

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
		assertTrue(!g.getVertices().contains(v1));
		assertTrue(!g.getVertices().contains(v2));
		assertTrue(!g.getAristas().contains(a));
		
	}
	
}
