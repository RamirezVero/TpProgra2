package entidades;


public abstract class Empleado {
	private String nombre;
	private String apellido;
	private int legajo;      //lo cambié de String a int
	private int cantRetrasos;
	private boolean asignado;
	
	 public Empleado(String nombre, String apellido, int legajo, int cantRetrasos, boolean asignado) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.legajo = legajo;
	        this.cantRetrasos = cantRetrasos;
	        this.asignado = asignado;
	    }
	 
	 
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getCantRetrasos() {
		return cantRetrasos;
	}

	public boolean isAsignado() {
		return asignado;
	}

	public int getLegajo() {
	    return legajo;
	}
	

	public void setLegajo(int legajo) {
	    this.legajo = legajo;
	}
}
