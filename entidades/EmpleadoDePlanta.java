package entidades;

enum Categoria{
	INICIAL, TECNICO, EXPERTO
	}
public class EmpleadoDePlanta extends Empleado {
	private double valorDia; 
	private Categoria categoriaActual;
	
	
	 

	public EmpleadoDePlanta(String nombre, String apellido, String legajo, int cantRetrasos, boolean asignado,  double valorDia, Categoria categoria ) {
		super(nombre, apellido, legajo, cantRetrasos, asignado);
		
		this.valorDia = valorDia; 
		this.categoriaActual = categoria;
	}

	public double getValorDia() {
		return valorDia;
	}

	public void setValorDia(double valorDia) {
		this.valorDia = valorDia;
	}

	public Categoria getCategoriaActual() {
		return categoriaActual;
	}
	
	

}
