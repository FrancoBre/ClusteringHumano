package juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GrafoTest {

	@Test
	void creacionDeGrafoTest() {
		
	}

	@Test
	void creacionDeVerticeTest() {
		
	}
	
	@Test
	void creacionDeAristaTest() {
		
	}
	
	@Test
	void insercionDeVertice() {
		Persona persona = new Persona(1, 3, 5, 1);
		Vertice vertice = new Vertice(persona);
//		vertice.insertarVecino(arista);
		assertTrue(vertice.getVecinos().contains(persona));
	}
	
	@Test
	void insercionDeVerticeIlegal() {
		Persona persona = new Persona(1, 3, 5, 1);
		Vertice vertice = new Vertice(persona);
		assertTrue(vertice.getVecinos().contains(persona));
	}
	
	@Test
	void insercionDeArista() {
		
	}
	
}
