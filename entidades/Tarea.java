package entidades;

import java.time.LocalDate;

public class Tarea {
	private int id;
	private String titulo;
	private String descripcion;
	private boolean medioDia;
	private double duracion;
	private double diasRetraso;
	private boolean estadoterminada;
	private LocalDate fechaPrevistaFin;
	private LocalDate fechaRealFin;
	private Empleado empleado;
	
	public Tarea(int id, String titulo, String descripcion, boolean medioDia, double diasEstimados, double diasRetraso,
			 LocalDate fechaPrevistaFin) {
		
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.medioDia = medioDia;
		this.duracion = diasEstimados;
		this.diasRetraso = diasRetraso;
		this.fechaPrevistaFin = fechaPrevistaFin;
	}

}
