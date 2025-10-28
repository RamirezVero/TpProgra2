package entidades;

public class Cliente {
	private String nombre; 
	private String apellido;
	private String correoElectronico;
	private String telefono;
	
	
	public Cliente(String nombre, String apellido, String correoElectronico, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}
	
	
	

}
