package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Busqueda {
	
	//BFS
	public static boolean esConexo(Grafo grafo) {
		if(grafo.getAristas().isEmpty()) return false;
		
		Map<Vertice, Boolean> marcados = inicializarMarcados(grafo);
		LinkedList <Vertice> pendientes = new LinkedList<Vertice>();
		pendientes.add(grafo.getVertices().get(0));
		
		while(!pendientes.isEmpty()) {
			Vertice i = pendientes.getFirst();
			
			marcados.put(i, true);
			
			for(Vertice v : pendientes.getFirst().getVecinos())  
				if(marcados.get(v)!=null && !marcados.get(v)) pendientes.add(v);
			
			pendientes.remove(i);
			
		}
		
		boolean ret = true;
		
		for(Vertice v : grafo.getVertices()) {
			if(!marcados.get(v)) {
				ret = false;
				break;
			}
		}
		
		return ret;
		
	}
	
	public static ArrayList<Vertice> alcanzablesDesde(Grafo grafo, Vertice v) {
		Map<Vertice, Boolean> marcados = inicializarMarcados(grafo);
		LinkedList <Vertice> pendientes = new LinkedList<Vertice>();
		pendientes.add(v);
		
		while(!pendientes.isEmpty()) {
			Vertice i = pendientes.getFirst();
			
			marcados.put(i, true);
			
			for(Vertice v1 : pendientes.getFirst().getVecinos())  
				if(marcados.get(v1)!=null && !marcados.get(v1)) 
					pendientes.add(v1);
			
			pendientes.remove(i);
			
		}
		
		ArrayList <Vertice> alcanzables = new ArrayList<Vertice>(); 
 
		//Agregar los vertices de marcados que tengan true
		for (Vertice v1 : marcados.keySet()) 
			
				if(marcados.get(v1)) alcanzables.add(v1);
		
		
		return alcanzables;
	}
	
	//Devuelve si el segundo vertice de la arista es alcanzable a partir del primer vertice
	//caso para el cual el grafo con esa arista formaria ciclo
	public static boolean formaCiclo(Grafo grafo, Arista arista) {	
		boolean ret;
		boolean yaConteniaV1 = false;	//Si ya contenia al vertice 1 o al vertice 2,
		boolean yaConteniaV2 = false;	//no se elimina del grafo, para dejarlo como estaba
		
		if(grafo.getVertices().contains(arista.getVertice1())) yaConteniaV1 = true;
		if(grafo.getVertices().contains(arista.getVertice2())) yaConteniaV2 = true;
		
		grafo.agregarArista(arista);
		grafo.eliminarArista(arista);
		
		ret = alcanzablesDesde(grafo, arista.getVertice1()).
				contains(arista.getVertice2());
		
		if(!yaConteniaV1) grafo.eliminarVertice(arista.getVertice1());
		if(!yaConteniaV2) grafo.eliminarVertice(arista.getVertice2());
		
		return ret;
	}

	private static Map<Vertice, Boolean> inicializarMarcados(Grafo grafo) {
		Map <Vertice, Boolean> marcados = new HashMap <Vertice, Boolean>(); 	
		
		for (Vertice v : grafo.getVertices()) {
			marcados.put(v, false);
		}
		
		return marcados;
	}
	
	public static ArrayList<Vertice> vecinosDe(Grafo grafo, Vertice v) {
		
		for(Vertice v1 : grafo.getVertices()) {
			if(v.equals(v1)) return v1.getVecinos();
		}

		return new ArrayList<Vertice>();
	}
	
	public static boolean tienePesoMinimo(ArrayList<Arista> aristas, Arista arista) {
		Arista min = aristas.get(0);
		
		for(Arista a : aristas) 
			if(a.getPeso() < min.getPeso()) min = a;
		
		return min.equals(arista);
	}
	
	public static boolean tienePesoMaximo(ArrayList<Arista> aristas, Arista arista) {
		Arista max = aristas.get(0);
				
		for(Arista a : aristas) 
			if(a.getPeso() > max.getPeso()) max = a;
				
		return max.equals(arista);
	}
	
	public static Arista aristaDePesoMaximo(Grafo grafo) {
		Arista max = grafo.getAristas().get(0);
		
		for(Arista a : grafo.getAristas()) 
			if(a.getPeso() > max.getPeso()) max = a;
				
		return max;
	}
	
	public static void eliminarAristaDeMayorPeso(Grafo grafo) {
		for(Arista a : grafo.getAristas()) {
			if(Busqueda.tienePesoMaximo(grafo.getAristas(), a)) 
				grafo.eliminarArista(a);
		}
	}

	//Devuelve las componentes conexas (grupos de personas) que quedan al eliminar la arista
	//de mayor peso en un grafo
	public static ArrayList<ArrayList<Vertice>> componentesConexas(Grafo grafo) {
		ArrayList<Vertice> componenteConexa1;
		ArrayList<Vertice> componenteConexa2;
		ArrayList<ArrayList<Vertice>> componentesConexas = new ArrayList<ArrayList<Vertice>>();
		
		eliminarAristaDeMayorPeso(grafo);
		componenteConexa1 = (Busqueda.alcanzablesDesde(grafo, aristaDePesoMaximo(grafo).getVertice1()));
		componenteConexa2 = (Busqueda.alcanzablesDesde(grafo, aristaDePesoMaximo(grafo).getVertice2()));
		
		componentesConexas.add(componenteConexa1);
		componentesConexas.add(componenteConexa2);
		
		return componentesConexas;
	}
	
}
