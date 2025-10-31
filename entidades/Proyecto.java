package entidades;

import java.util.Map;
import java.util.Set;

public class Proyecto {
	private Integer id;
	private Cliente cliente;
	private Tarea tarea;
	
	private String[] tituloTarea;
	private String[] descripTarea;
	private double[] duracion;
	private String domicilio;
	private String[] clienteDatos;
	private String fechaPrevistaFin;
	private String fechaFin;
	
	private Estado estado;
	private Map<String, Tarea>tareas;
	private Set<Empleado>historialEmpleados;
	private boolean finalizado;
	private double costoAcumulado;
	private boolean huboRetraso;
	
	
	/*public Proyecto(Cliente cliente, Tarea tituloTarea, int id, String direccion,    //este era nuestro constructor
	 *  LocalDate fechaPrevistaFin, Map<String, Tarea> tareas) {
		this.cliente = cliente;
		this.tituloTarea = tituloTarea;
		this.id = id;
		this.direccion = direccion;
		this.fechaPrevistaFin = fechaPrevistaFin;
		this.tareas = tareas;
	}*/


	public Proyecto(String[] tituloTarea, String[] descripTarea, double[] duracion, String domicilio,
			String[] cliente, String fechaInicio, String fechaFin) {
		this.tituloTarea = tituloTarea;
		this.descripTarea = descripTarea;
		this.duracion = duracion;
		this.domicilio = domicilio;
		this.clienteDatos = cliente;
		this.fechaPrevistaFin = fechaInicio;
		this.fechaFin = fechaFin;
	}


	
	public Integer getId() {
		return id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Tarea getTarea() {
		return tarea;
	}
	public String[] getTituloTarea() {
		return tituloTarea;
	}
	public String[] getDescripTarea() {
		return descripTarea;
	}
	public double[] getDuracion() {
		return duracion;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public String[] getClienteDatos() {
		return clienteDatos;
	}
	public String getFechaPrevistaFin() {
		return fechaPrevistaFin;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public Estado getEstado() {
		return estado;
	}
	public Map<String, Tarea> getTareas() {
		return tareas;
	}
	public Set<Empleado> getHistorialEmpleados() {
		return historialEmpleados;
	}
	public boolean estaFinalizado() {
		return finalizado;
	}

	public double getCostoAcumulado() {
		return costoAcumulado;
	}
	public boolean isHuboRetraso() {
		return huboRetraso;
	}
	
	public void setId(Integer id) {
		this.id = id;		
	}



	public Tarea getTareaPorTitulo(String titulo) {		
		return tarea;
	}


	
	
	

}
