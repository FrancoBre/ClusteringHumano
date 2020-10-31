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
	
}
