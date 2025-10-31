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

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isMedioDia() {
		return medioDia;
	}

	public double getDuracion() {
		return duracion;
	}

	public double getDiasRetraso() {
		return diasRetraso;
	}

	public boolean isEstadoterminada() {
		return estadoterminada;
	}

	public LocalDate getFechaPrevistaFin() {
		return fechaPrevistaFin;
	}

	public LocalDate getFechaRealFin() {
		return fechaRealFin;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setMedioDia(boolean medioDia) {
		this.medioDia = medioDia;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public void setDiasRetraso(double diasRetraso) {
		this.diasRetraso = diasRetraso;
	}

	public void setEstadoterminada(boolean estadoterminada) {
		this.estadoterminada = estadoterminada;
	}

	public void setFechaPrevistaFin(LocalDate fechaPrevistaFin) {
		this.fechaPrevistaFin = fechaPrevistaFin;
	}

	public void setFechaRealFin(LocalDate fechaRealFin) {
		this.fechaRealFin = fechaRealFin;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}	
	

}
