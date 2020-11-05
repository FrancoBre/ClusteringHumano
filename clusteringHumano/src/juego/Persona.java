package juego;

public class Persona {
	
	private String nombre;
	private int m;
	private int d;
	private int e;
	private int c;
	
	public Persona(int musica, int deportes, int espectaculo, int ciencia) {
		if(musica>=0 && musica<=5) this.m=musica;
		else verificarIlegales("musica");
		
		if(deportes>=0 && deportes<=5) this.d=deportes;
		else verificarIlegales("deportes");
		
		if(espectaculo>=0 && espectaculo<=5) this.e=espectaculo;
		else verificarIlegales("espectaculo");
		
		if(espectaculo>=0 && espectaculo<=5) this.c=ciencia;
		else verificarIlegales("espectaculo");
	}
	
	public Persona(int musica, int deportes, int espectaculo, int ciencia, String nombre) {
		if(musica>=0 && musica<=5) this.m=musica;
		else verificarIlegales("musica");
		
		if(deportes>=0 && deportes<=5) this.d=deportes;
		else verificarIlegales("deportes");
		
		if(espectaculo>=0 && espectaculo<=5) this.e=espectaculo;
		else verificarIlegales("espectaculo");
		
		if(espectaculo>=0 && espectaculo<=5) this.c=ciencia;
		else verificarIlegales("espectaculo");
		
		this.nombre = nombre;
	}
	
	public int indiceDeSimilaridad(Persona j) {
		return(Math.abs(d-j.getD())+Math.abs(m-j.getM())+Math.abs((e-j.getE()))+Math.abs(c-j.getC()));
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		verificarIlegales("musica");
		this.m = m;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		verificarIlegales("deportes");
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		verificarIlegales("espectaculo");
		this.e = e;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		verificarIlegales("ciencia");
		this.c = c;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void verificarIlegales(String indice) {
		throw new IllegalArgumentException("Los indices deben ser mayores que 0 y menores que 5= "+indice);
	}
	
	@Override
	public boolean equals(Object o) {
	    
	   Persona persona = (Persona) o;
	   	 
	   if(this.c==persona.getC() && 
	      this.d==persona.getD() &&
	      this.e==persona.getE() &&
	      this.m==persona.getM()) 
	   return true; 
	   else return false;   

	}
	
	@Override
	public String toString() {
		return nombre+"\nindices de gustos:\nmusica= "+m+", "
				+ "deportes= "+d+", espectaculo= "+e+", ciencia= "+c;
				
	}
}
