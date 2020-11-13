package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import interfaz.Aplicacion;
import logica.Arista;
import logica.GCompleto;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;

class AplicacionTest {

	@Test
	public void personasVacioTest() {
		Aplicacion aplicacion = new Aplicacion();
		
		assertTrue(aplicacion.getPersonas().isEmpty());
	}
	
	@Test
	public void personasNoVacioTest() {
		Aplicacion aplicacion = new Aplicacion();
		Persona persona = new Persona(3, 2, 1, 5, "");
		aplicacion.crearPersona(persona);
		
		assertTrue(!aplicacion.getPersonas().isEmpty());
	}
	
	@Test
	public void crearPersonasTest() {
		Aplicacion aplicacion = new Aplicacion();
		Persona persona = new Persona(3, 2, 3, 5, "");
		Persona persona2 = new Persona(1, 4, 4, 2, "");
		
		aplicacion.crearPersona(persona);
		aplicacion.crearPersona(persona2);
		
		Vertice v1 = new Vertice(persona);
		Vertice v2 = new Vertice(persona2);
		
		aplicacion.crearAristas();
		
		assertTrue(aplicacion.getGrafo().getVertices().contains(v1));
		assertTrue(aplicacion.getGrafo().getVertices().contains(v2));
		assertFalse(aplicacion.getGrafo().getAristas().isEmpty());
//		assertTrue(aplicacion.getGrafo().existeArista(new Arista(v1, v2)));

	}
	
	@Test
	public void crearPersonasTest2() {
		Aplicacion aplicacion = new Aplicacion();
		Persona persona = new Persona(3, 2, 3, 5, "");
		Persona persona2 = new Persona(1, 4, 4, 2, "");
		Persona persona3 = new Persona(5, 1, 1, 2, "");
		
		aplicacion.crearPersona(persona);
		aplicacion.crearPersona(persona2);
		aplicacion.crearPersona(persona3);
		
		Vertice v1 = new Vertice(persona);
		Vertice v2 = new Vertice(persona2);
		Vertice v3 = new Vertice(persona3);
		Arista arista = new Arista(v1, v2);
		Arista arista2 = new Arista(v2, v3);
		Arista arista3 = new Arista(v2, v1);
		
		aplicacion.crearAristas();
		
		assertTrue(aplicacion.getGrafo().existeArista(arista));
		assertTrue(aplicacion.getGrafo().existeArista(arista2));
		assertTrue(aplicacion.getGrafo().existeArista(arista3));
	}
	
	@Test
	public void crearPersonasRepetidasTest() {
		Aplicacion aplicacion = new Aplicacion();
		Persona persona = new Persona(3, 2, 1, 5, "Pepe Grillo");
		Persona persona2 = new Persona(3, 2, 1, 5, "Pepe Grillo");
		
		aplicacion.crearPersona(persona);
		aplicacion.crearPersona(persona2);
		
		assertTrue(aplicacion.getPersonas().contains(persona));
		assertTrue(aplicacion.getPersonas().contains(persona2));
	}
	
	@Test
	public void creacionDeClusterTest1() { 
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
		
		Aplicacion app = new Aplicacion();
		
		app.crearPersona(i);
		app.crearPersona(j);
		app.crearPersona(x);
		app.crearPersona(y);
		app.crearPersona(z);
		
		app.crearAristas();
				
		assertTrue(app.getCluster().getGrupo2().contains(v1));
		assertTrue(app.getCluster().getGrupo2().contains(v2));
		assertTrue(app.getCluster().getGrupo2().contains(v3));
		
		assertTrue(app.getCluster().getGrupo1().contains(v4));
		assertTrue(app.getCluster().getGrupo1().contains(v5));
	}	
	
	@Test
	public void creacionDeClusterTest2() { 
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
				
		assertTrue(app.getCluster().getGrupo1().contains(v1));
		assertTrue(app.getCluster().getGrupo1().contains(v2));
		assertTrue(app.getCluster().getGrupo1().contains(v3));
//		assertTrue(app.getCluster().getGrupo1().contains(v6));
		
		assertTrue(app.getCluster().getGrupo2().contains(v4));
		assertTrue(app.getCluster().getGrupo2().contains(v5));
	}	
}

