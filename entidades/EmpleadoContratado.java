package entidades;

public class EmpleadoContratado extends Empleado {
	
	private double valorHora;

	public EmpleadoContratado(String nombre, String apellido, String legajo, int cantRetrasos, boolean asignado,  double valorHora) {
		super(nombre, apellido, legajo, cantRetrasos, asignado); // constructor de Empleado
		this.valorHora = valorHora;
		
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	

}
