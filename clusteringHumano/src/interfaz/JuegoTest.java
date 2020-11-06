package interfaz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import juego.Arista;
import juego.Persona;
import juego.Vertice;

class JuegoTest {

	@Test
	public void personasVacioTest() {
		Juego juego = new Juego();
		
		assertTrue(juego.getPersonas().isEmpty());
	}
	
	@Test
	public void personasNoVacioTest() {
		Juego juego = new Juego();
		Persona persona = new Persona(3, 2, 1, 5);
		juego.crearPersona(persona);
		
		assertTrue(!juego.getPersonas().isEmpty());
	}
	
	@Test
	public void crearPersonasTest() {
		Juego juego = new Juego();
		Persona persona = new Persona(3, 2, 3, 5);
		Persona persona2 = new Persona(1, 4, 4, 2);
		
		juego.crearPersona(persona);
		juego.crearPersona(persona2);
		
		Vertice v1 = new Vertice(persona);
		Vertice v2 = new Vertice(persona2);
		Arista arista = new Arista(v1, v2);
		
		assertTrue(juego.getGrafo().existeArista(arista));

	}
	
	@Test
	public void crearPersonasTest2() {
		Juego juego = new Juego();
		Persona persona = new Persona(3, 2, 3, 5);
		Persona persona2 = new Persona(1, 4, 4, 2);
		Persona persona3 = new Persona(5, 1, 1, 2);
		
		juego.crearPersona(persona);
		juego.crearPersona(persona2);
		juego.crearPersona(persona3);
		
		Vertice v1 = new Vertice(persona);
		Vertice v2 = new Vertice(persona2);
		Vertice v3 = new Vertice(persona3);
		Arista arista = new Arista(v1, v2);
		Arista arista2 = new Arista(v2, v3);
		Arista arista3 = new Arista(v2, v1);
		
		assertTrue(juego.getGrafo().existeArista(arista));
		assertTrue(juego.getGrafo().existeArista(arista2));
		assertTrue(juego.getGrafo().existeArista(arista3));

	}
	
	@Test
	public void crearPersonasTest3() {
		Juego juego = new Juego();
		Persona persona = new Persona(3, 2, 3, 5);
		Persona persona2 = new Persona(1, 4, 4, 2);
		Persona persona3 = new Persona(5, 1, 1, 2);
		
		juego.crearPersona(persona);
		juego.crearPersona(persona2);
		juego.crearPersona(persona3);
		
		Vertice v1 = new Vertice(persona);
		Vertice v3 = new Vertice(persona3);
		Arista arista = new Arista(v3, v1);
		
		assertTrue(juego.getGrafo().existeArista(arista));
		
	}
	
	@Test
	public void crearPersonasRepetidasTest() {
		Juego juego = new Juego();
		Persona persona = new Persona(3, 2, 1, 5, "Pepe Grillo");
		Persona persona2 = new Persona(3, 2, 1, 5, "Pepe Grillo");
		
		juego.crearPersona(persona);
		juego.crearPersona(persona2);
		
		assertTrue(juego.getPersonas().contains(persona));
		assertTrue(juego.getPersonas().contains(persona2));
	}
	
}
