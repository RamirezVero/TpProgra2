package entidades;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HomeSolution {
	private Proyecto proyecto;
	private Empleado empleado;
	private Map<Integer, Proyecto>proyectos;
	private Map<Integer, Empleado>empleados;
	private Queue<Empleado>empleadosDisponibles;

	public void registrarProyecto(String[] titulos, String[] descripciones, double[] duracion, String string,
			String[] cliente, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}

	public void registrarEmpleado(String string, int i) {
		// TODO Auto-generated method stub
		
	}

	public void registrarEmpleado(String string, int i, String string2) {
		// TODO Auto-generated method stub
		
	}

	public Object[] tareasDeUnProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registrarEmpleado(String text, double double1, String string) {
		// TODO Auto-generated method stub
		
	}

	public void registrarEmpleado(String text, double double1) {
		// TODO Auto-generated method stub
		
	}

	public void asignarResponsableEnTarea(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}

	public void asignarResponsableMenosRetraso(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}

	public Object[] empleadosNoAsignados() {
		// TODO Auto-generated method stub
		return null;
	}

	public void reasignarEmpleadoEnProyecto(Integer consultarSeleccionado, Integer legajo, String titulo) {
		// TODO Auto-generated method stub
		
	}

	public void reasignarEmpleadoConMenosRetraso(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}

	public void finalizarTarea(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}

	public void registrarRetrasoEnTarea(Integer consultarSeleccionado, String titulo, double dias) {
		// TODO Auto-generated method stub
		
	}

	public void agregarTareaEnProyecto(Integer consultarSeleccionado, String titulo, String descripcion,
			double double1) {
		// TODO Auto-generated method stub
		
	}

	public double costoProyecto() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void finalizarProyecto(Integer consultarSeleccionado, String fecha) {
		// TODO Auto-generated method stub
		
	}

	public List<Tupla<Integer, String>> empleadosAsignadosAProyecto(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return null;
	}

	public String consultarProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}

	public String consultarDomicilioProyecto(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean estaFinalizado(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return false;
	}
//gui:gestionEmpleados
	public int consultarCantidadRetrasosEmpleado(int int1) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Tupla<Integer, String>> empleados() {
		// TODO Auto-generated method stub
		return null;
	}
//gui ListaProyectos
	public List<Tupla<Integer, String>> proyectosPendientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tupla<Integer, String>> proyectosActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tupla<Integer, String>> proyectosFinalizados() {
		// TODO Auto-generated method stub
		return null;
	}




}
