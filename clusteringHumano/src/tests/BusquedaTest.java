package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import logica.AGM;
import logica.Arista;
import logica.Busqueda;
import logica.GCompleto;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;

class BusquedaTest {

	@Test
	public void esConexoTest1() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		Persona y = new Persona(1, 3, 5, 4, "");
		
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
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		
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
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 3, 2, 4, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		
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
	public void alcanzablesDesdeTest1() {
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
	
	@Test
	public void alcanzablesDesdeTest2() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(4, 2, 5, 5, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);

		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		
		assertTrue(Busqueda.alcanzablesDesde(g, v1).contains(v2));
		assertTrue(Busqueda.alcanzablesDesde(g, v1).contains(v3));
		
		g.eliminarArista(a1);
		g.eliminarArista(a2);
		
		assertFalse(Busqueda.alcanzablesDesde(g, v2).contains(v1));
		assertFalse(Busqueda.alcanzablesDesde(g, v2).contains(v3));
	}
	
	@Test
	public void alcanzablesDesdeTest3() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(4, 2, 5, 5, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		Persona y = new Persona(5, 5, 2, 1, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		
		Arista a1 = new Arista(v3, v4);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v1, v3);

		Grafo agm = new Grafo();
		
		agm.agregarArista(a1);
		agm.agregarArista(a2);
		agm.agregarArista(a3);
		
		assertTrue(Busqueda.alcanzablesDesde(agm, v1).contains(v2));
		
	}
	
	@Test
	public void alcanzablesDesdeTest4() {
		Persona i = new Persona(1, 2, 1, 5, "vertice 1");
		Persona j = new Persona(4, 2, 5, 5, "vertice 2");
		Persona x = new Persona(3, 1, 2, 4, "vertice 3");
		Persona y = new Persona(3, 5, 5, 1, "vertice 4");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		
		Grafo grafo = new Grafo();
		
		Arista a1 = new Arista(v1, v3);
		Arista a2 = new Arista(v3, v2);
		Arista a3 = new Arista(v2, v4);
		
		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		
		Arista apm = Busqueda.aristaDePesoMaximo(grafo);
		
		assertEquals(a3, apm);
		
		assertTrue(Busqueda.alcanzablesDesde(grafo, apm.getVertice1()).contains(v1));
		
		assertTrue(Busqueda.alcanzablesDesde(grafo, apm.getVertice2()).contains(v2));
		assertTrue(Busqueda.alcanzablesDesde(grafo, apm.getVertice2()).contains(v3));
		assertTrue(Busqueda.alcanzablesDesde(grafo, apm.getVertice2()).contains(v4));
	}
	
	@Test
	public void alcanzablesDesdeTest5() {
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
		
		//Se crea bien el AGM a partir del grafo completo?
		assertTrue(agm.getAristas().contains(new Arista(v1, v3)));
		assertTrue(agm.getAristas().contains(new Arista(v2, v3)));
		assertTrue(agm.getAristas().contains(new Arista(v4, v2)));
		assertFalse(agm.getAristas().contains(a1));
		
		Arista apm = Busqueda.aristaDePesoMaximo(agm);
		
		Arista a4 = new Arista(v4, v2);
		
		//La arista de mayor peso es la que corresponde?
		assertEquals(a4, apm);
		
		Busqueda.eliminarAristaDeMayorPeso(agm);
		
		//Los alcanzables desde los vertices de la arista de mayor peso son los que 
		//corresponden?
		assertTrue(Busqueda.alcanzablesDesde(agm, apm.getVertice1()).contains(v4));
		
		assertTrue(Busqueda.alcanzablesDesde(agm, apm.getVertice2()).contains(v2));
		assertTrue(Busqueda.alcanzablesDesde(agm, apm.getVertice2()).contains(v3));
		assertTrue(Busqueda.alcanzablesDesde(agm, apm.getVertice2()).contains(v1));
	}
	
	@Test
	public void noAlcanzablesDesdeTest1() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(4, 2, 5, 5, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v1, v3);

		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.eliminarArista(a3);
		g.eliminarArista(a2);
		
		assertFalse(Busqueda.alcanzablesDesde(g, v1).contains(v3));
		assertTrue(g.getVertices().contains(v3));
		
	}
	
	@Test
	public void noAlcanzablesDesdeTest2() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(4, 2, 5, 5, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);

		Grafo g = new GCompleto();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.eliminarArista(a1);
		g.eliminarArista(a2);
		
		assertTrue(Busqueda.alcanzablesDesde(g, v1).contains(v3));
		assertTrue(g.getVertices().contains(v2));
		
	}

	@Test
	public void noAlcanzablesDesdeTest3() {
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
		
		Arista a1 = new Arista(v3, v1);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v4, v5);
		
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		
		assertFalse(Busqueda.alcanzablesDesde(g, v5).contains(v1));
	}
	
	@Test
	public void noFormaCicloTest1() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 5, 1, 4, "");
		Persona x = new Persona(1, 2, 1, 5, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		
		Arista a1 = new Arista(v1, v2);
		
		Grafo agm = new Grafo();
		agm.agregarArista(a1);
		
		assertFalse(Busqueda.formaCiclo(agm, new Arista(v2, v3)));
	}
	
	@Test
	public void noFormaCicloTest2() {
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
		
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		
		assertFalse(Busqueda.formaCiclo(g, new Arista(v4, v5)));
	}
	
	@Test
	public void noFormaCicloTest3() {
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
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v5, v4);
		
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		
		assertFalse(Busqueda.formaCiclo(g, new Arista(v5, v1)));
	}
	
	@Test
	public void formaCicloTest1() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(3, 5, 1, 4, "");
		Persona x = new Persona(1, 2, 1, 5, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		
		Arista a1 = new Arista(v1, v2);
		Arista a2 = new Arista(v2, v3);
		
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		
		assertTrue(Busqueda.formaCiclo(g, new Arista(v1, v3)));
	}
	
	@Test
	public void formaCicloTest2() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(4, 2, 5, 5, "");
		Persona x = new Persona(3, 1, 2, 4, "");
		Persona y = new Persona(3, 5, 5, 1, "");
		
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
		Vertice v4 = new Vertice(y);
		
		Arista a1 = new Arista(v1, v3);
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v3, v4);
		Arista a4 = new Arista(v1, v2);
		
		Grafo g = new Grafo();
		
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		g.agregarArista(a4);
		
		assertTrue(Busqueda.formaCiclo(g, a4));
	}
	
	@Test
	public void formaCicloTest3() {
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
		Arista a2 = new Arista(v2, v3);
		Arista a3 = new Arista(v4, v5);

		Grafo g = new Grafo();
			
		g.agregarArista(a1);
		g.agregarArista(a2);
		g.agregarArista(a3);
		
		assertTrue(g.existeArista(a1));
		assertTrue(g.existeArista(a2));
		assertTrue(g.existeArista(a3));
		
		assertTrue(Busqueda.formaCiclo(g, new Arista(v1, v2)));
		
		assertFalse(g.existeArista(new Arista(v1, v2)));
		
	}
	
	@Test
	public void formaCicloTest4() {
		Persona i = new Persona(1, 2, 1, 5, "");
		Persona j = new Persona(4, 2, 5, 5, "");
		Persona x = new Persona(3, 1, 2, 4, "");
			
		Vertice v1 = new Vertice(i);
		Vertice v2 = new Vertice(j);
		Vertice v3 = new Vertice(x);
			
		Arista a1 = new Arista(v3, v1);
		Arista a2 = new Arista(v2, v3);
		
		Grafo g = new Grafo();
			
		g.agregarArista(a1);
		g.agregarArista(a2);
		
		assertTrue(g.existeArista(a1));
		assertTrue(g.existeArista(a2));
		
		assertTrue(g.getVertices().contains(v1));
		assertTrue(g.getVertices().contains(v2));
		assertTrue(g.getVertices().contains(v3));
		
		assertTrue(Busqueda.formaCiclo(g, new Arista(v1, v2)));
		
	}
	
	@Test
	public void vecinosDeGrafoTest() {
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
		
		assertTrue(Busqueda.vecinosDe(g, v1).contains(v2));
		assertTrue(Busqueda.vecinosDe(g, v2).contains(v1));
		assertTrue(Busqueda.vecinosDe(g, v2).contains(v3));
		assertTrue(Busqueda.vecinosDe(g, v3).contains(v2));
		
	}
	
	@Test
	public void vecinosDeAGMTest() {
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
		
		assertTrue(Busqueda.vecinosDe(g, v1).contains(v2));
		assertTrue(Busqueda.vecinosDe(g, v2).contains(v1));
		assertTrue(Busqueda.vecinosDe(g, v2).contains(v3));
		assertTrue(Busqueda.vecinosDe(g, v3).contains(v2));
		assertFalse(Busqueda.vecinosDe(g, v1).contains(v3));
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
		
		assertTrue(Busqueda.tienePesoMinimo(aristas, a1));
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
		
		assertFalse(Busqueda.tienePesoMinimo(aristas, a1));
	}	
}
