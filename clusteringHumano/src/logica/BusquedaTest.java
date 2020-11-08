package logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusquedaTest {

	@Test
	public void esConexoTest1() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		Persona x = new Persona(3, 1, 2, 4);
		Persona y = new Persona(1, 3, 5, 4);
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		
		assertTrue(Busqueda.esConexo(g));
		
	}
	
	@Test
	public void esConexoTest2() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		
		Arista a1 = new Arista(v1, v2);
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		
		assertTrue(Busqueda.esConexo(g));
	}
	
	@Test
	public void noEsConexoTest1() {
		Grafo g = new Grafo();
		
		assertFalse(Busqueda.esConexo(g));
	}
	
	@Test
	public void noEsConexoTest2() {
		Persona i = new Persona(1, 2, 1, 5);
		Persona j = new Persona(3, 3, 2, 4);
		Persona x = new Persona(3, 1, 2, 4);
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v1, v3);
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		
		g.eliminarArista(a1);
		g.eliminarArista(a3);
		
		assertTrue(!Busqueda.esConexo(g));
		assertTrue(g.existeArista(a2));
		
	}
	
	@Test
	public void alcanzablesDesdeTest() {
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
		
		assertTrue(Busqueda.alcanzablesDesde(g, v1).contains(v1));
		assertTrue(Busqueda.alcanzablesDesde(g, v1).contains(v2));
		assertTrue(Busqueda.alcanzablesDesde(g, v1).contains(v3));
		assertTrue(Busqueda.alcanzablesDesde(g, v1).contains(v4));
		assertTrue(Busqueda.alcanzablesDesde(g, v1).contains(v5));
		
	}

}