package entidades;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class Proyecto {
	private Integer id;
	private Cliente cliente;
	private Tarea tarea;	
	private String direccion;
	private LocalDate fechaPrevistaFin;
	private LocalDate fechaRealFin;
	private Estado estado;
	private Map<String, Tarea>tareas;
	private Set<Empleado>historialEmpleados;
	private boolean finalizado;
	private double costoAcumulado;
	private boolean huboRetraso;
	
	
	public Proyecto(Cliente cliente, Tarea tarea, int id, String direccion, LocalDate fechaPrevistaFin,
			 Map<String, Tarea> tareas) {
		this.cliente = cliente;
		this.tarea = tarea;
		this.id = id;
		this.direccion = direccion;
		this.fechaPrevistaFin = fechaPrevistaFin;
		this.tareas = tareas;
	}
	
	
	

}
