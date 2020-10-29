package juego;

public class Persona {
	private int m;
	private int d;
	private int e;
	private int c;
	
	public Persona(int musica, int deportes, int espectaculo, int ciencia) {
		if(musica>=0 && musica<=5) this.m=musica;
		if(deportes>=0 && deportes>=5) this.d=deportes;
		if(espectaculo>=0 && espectaculo>=5) this.e=espectaculo;
		if(espectaculo>=0 && espectaculo>=5) this.c=ciencia;
	}
	
	public int indiceDeSimilaridad(Persona j) {
		return(Math.abs(d-j.getD())-Math.abs(m-j.getM())-Math.abs((e-j.getE()))-Math.abs(c-j.getC()));
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		if(m<=0) throw new IllegalArgumentException("El indice de interes por la musica debe ser mayor a 0");
		if(m>=5) throw new IllegalArgumentException("El indice de interes por la musica debe ser menor a 5");
		this.m = m;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		if(d<=0) throw new IllegalArgumentException("El indice de interes por los deportes debe ser mayor a 0");
		if(d>=5) throw new IllegalArgumentException("El indice de interes por los deportes debe ser menor a 5");
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		if(e<=0) throw new IllegalArgumentException("El indice de interes por el espectaculo debe ser mayor a 0");
		if(e>=5) throw new IllegalArgumentException("El indice de interes por el espectaculo debe ser menor a 5");
		this.e = e;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		if(c<=0) throw new IllegalArgumentException("El indice de interes por la ciencia debe ser mayor a 0");
		if(c>=5) throw new IllegalArgumentException("El indice de interes por la ciencia debe ser menor a 5");
		this.c = c;
	}
	
}
