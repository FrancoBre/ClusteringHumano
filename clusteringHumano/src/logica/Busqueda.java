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
				if(!marcados.get(v)) pendientes.add(v);
			
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
		grafo.agregarArista(arista);
		grafo.eliminarArista(arista);
		
		return(alcanzablesDesde(grafo, arista.getVertice1()).
				contains(arista.getVertice2()))?true:false;
	}
	
	public int distanciaEntre(Grafo grafo, Vertice v1, Vertice v2) {
		return 0;
	}
	
	public int cantComponentesConexas(Grafo grafo) {
		return 0;
	}

	private static Map<Vertice, Boolean> inicializarMarcados(Grafo grafo) {
		Map <Vertice, Boolean> marcados = new HashMap <Vertice, Boolean>(); 	
		
		for (Vertice v : grafo.getVertices()) {
			marcados.put(v, false);
		}
		
		return marcados;
	}
}