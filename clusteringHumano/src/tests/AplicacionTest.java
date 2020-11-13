package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import interfaz.Aplicacion;
import logica.Arista;
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
	public void crearPersonasTest3() {
		Aplicacion aplicacion = new Aplicacion();
		Persona persona = new Persona(3, 2, 3, 5, "");
		Persona persona2 = new Persona(1, 4, 4, 2, "");
		Persona persona3 = new Persona(5, 1, 1, 2, "");
		
		aplicacion.crearPersona(persona);
		aplicacion.crearPersona(persona2);
		aplicacion.crearPersona(persona3);
		
		Vertice v1 = new Vertice(persona);
		Vertice v3 = new Vertice(persona3);
		Arista arista = new Arista(v1, v3);
		
		aplicacion.crearAristas();
		
		assertTrue(aplicacion.getGrafoCompleto().existeArista(arista));
		
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
}

