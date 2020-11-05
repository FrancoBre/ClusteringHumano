package interfaz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import juego.Arista;
import juego.Grafo;
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
		Vertice v2 = new Vertice(persona);
		Arista arista = new Arista(v1, v2);
		
		assertTrue(juego.getGrafo().existeArista(arista));
//		assertTrue(juego.getGrafo().getAristas().get(0).getPeso()==8);
		assertEquals(8, arista.getPeso());

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
