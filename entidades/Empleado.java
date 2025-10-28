package entidades;

public abstract class Empleado {
	private String nombre;
	private String apellido;
	private String legajo;
	private int cantRetrasos;
	private boolean asignado;
	
	public Empleado(String nombre, String apellido, String legajo, int cantRetrasos, boolean asignado ){
		this.nombre = nombre; 
		this.apellido = apellido;
		this.legajo = legajo; 
		this.asignado= asignado;
	}

	
}
