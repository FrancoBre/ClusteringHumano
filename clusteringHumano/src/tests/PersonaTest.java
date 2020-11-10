package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logica.Persona;

class PersonaTest {
	
	@Test
	void creacionPersonaTest() {
		Persona i = new Persona(1, 2, 3, 1, "");
		assertEquals(1, i.getM());
		assertEquals(2, i.getD());
		assertEquals(3, i.getE());
		assertEquals(1, i.getC());
	}

	@Test
	void indiceDeSimilaridadTest1() {
		Persona i = new Persona(4, 5, 3, 1, "");
		Persona j = new Persona(4, 5, 3, 1, "");
		assertEquals(0, i.indiceDeSimilaridad(j));
	}
	
	@Test
	void indiceDeSimilaridadTest2() {
		Persona i = new Persona(3, 2, 3, 5, "");
		Persona j = new Persona(1, 4, 4, 2, "");
		assertEquals(8, i.indiceDeSimilaridad(j));
	}
	
}