package entidades;

public class EmpleadoContratado extends Empleado {
	
	private double valorHora;

	public EmpleadoContratado(String nombre, String apellido, int legajo, int cantRetrasos, boolean asignado, double valorHora) {
        super(nombre, apellido, legajo, 0, false);
        this.valorHora = valorHora;
    }

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
}
