package interfaz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import juego.Arista;
import juego.Grafo;
import juego.Persona;
import juego.Vertice;

class JuegoTest {

	@Test
	public void crearPersonaTest() {
		Juego juego = new Juego();
		juego.crearPersona(3, 2, 1, 5);
		
		assertTrue(juego.getPersonas().get(0).equals(new Persona(3, 2, 1, 5)));
		
	}

	@Test
	public void personasVacioTest() {
		Juego juego = new Juego();
		
		assertTrue(juego.getPersonas().isEmpty());
	}
	
	@Test
	public void personasNoVacioTest() {
		Juego juego = new Juego();
		juego.crearPersona(3, 2, 1, 5);
		
		assertTrue(!juego.getPersonas().isEmpty());
	}
	
	@Test
	public void crearAristaTest() {
		Juego juego = new Juego();
		juego.crearPersona(3, 2, 1, 5);
		juego.crearPersona(5, 2, 3, 3);
		Arista arista = new Arista(new Vertice(new Persona(3, 2, 1, 5)), 
				new Vertice(new Persona(5, 2, 3, 3)));
		
		assertTrue(juego.getGrafo().existeArista(arista));
		
	}
	
}