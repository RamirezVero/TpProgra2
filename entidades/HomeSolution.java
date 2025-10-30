package entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HomeSolution implements IHomeSolution {
	private Proyecto proyecto;
	private Empleado empleado;
	private Map<Integer, Proyecto>proyectos= new HashMap<>();
	private Map<Integer, Empleado> empleados = new HashMap<>();
	private int contadorLegajos = 1;
	private Queue<Empleado>empleadosDisponibles;
	
	/*Se agregan las siguientes funcionalidades:
- 19 Obtener tareas de un proyecto que aún no hayan sido asignadas.
- 20 Consultar el domicilio de un proyecto, a partir de su número.
- 21 Indicar si un empleado del cual se conoce su legajo, tiene retrasos.
- 22 obtener todos los empleados de HomeSolution*/
	
	
	/**
     * Registra un empleado con un nombre y un valor base por hora.     *
     * @param nombre Nombre del empleado.
     * @param valor Valor de trabajo del empleado.
     * @throws IllegalArgumentException Si el nombre es nulo o vacío, o el valor es negativo.
     */
	@Override
	public void registrarEmpleado(String nombre, double valor) {// parámetros de empleado contratado 
		 // Validamos datos
        if (nombre == null || nombre.isEmpty() || valor <= 0) {
            throw new IllegalArgumentException("Hay datos inválidos");
        }        
        int legajo = contadorLegajos++;
        
        EmpleadoContratado nuevo = new EmpleadoContratado(
        	    nombre, "", legajo,0,false, valor
        	);
        nuevo.setLegajo(legajo);

        empleados.put(legajo, nuevo);
	}


	 /* Registra un empleado con nombre, valor y categoría.     *
     * @param nombre Nombre del empleado.
     * @param valor Valor de trabajo del empleado.
     * @param categoria Categoría del empleado (por ejemplo, "Junior", "Senior").
     * @throws IllegalArgumentException Si alguno de los parámetros es inválido.
     */
	@Override
	public void registrarEmpleado(String nombre, double valor, String categoria) {//parámetros de EmpleadoDePlanta
	    if (nombre == null || nombre.isEmpty())
	        throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");           
	    if (valor < 0)
	        throw new IllegalArgumentException("El valor no puede ser negativo.");

	    int legajo = contadorLegajos++;
	    EmpleadoDePlanta e = new EmpleadoDePlanta(nombre, "", legajo, 0, false, valor, categoria);
	    empleados.put(legajo, e);
	}
	//prueba
	public void listarEmpleados() {
	    for (Empleado e : empleados.values()) {
	        System.out.println("Legajo: " + e.getLegajo() + " | Nombre: " + e.getNombre());
	    }
	}

	
	@Override
	public void asignarResponsableEnTarea(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void asignarResponsableMenosRetraso(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object[] empleadosNoAsignados() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Tupla<Integer, String>> empleados() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void registrarProyecto(String[] titulos, String[] descripciones, double[] duracion, String string,
			String[] cliente, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}	
	@Override
	public List<Tupla<Integer, String>> empleadosAsignadosAProyecto(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double costoProyecto() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void finalizarProyecto(Integer consultarSeleccionado, String fecha) {
		// TODO Auto-generated method stub
		
	}
	public String consultarProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean estaFinalizado(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return false;
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
	
		
	@Override
	public Object[] tareasDeUnProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}	
	@Override
	public void reasignarEmpleadoEnProyecto(Integer consultarSeleccionado, Integer legajo, String titulo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reasignarEmpleadoConMenosRetraso(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void finalizarTarea(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registrarRetrasoEnTarea(Integer consultarSeleccionado, String titulo, double dias) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void agregarTareaEnProyecto(Integer consultarSeleccionado, String titulo, String descripcion,
			double double1) {
		// TODO Auto-generated method stub
		
	}
	

	

	
	@Override
	public String consultarDomicilioProyecto(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int consultarCantidadRetrasosEmpleado(Integer legajo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object[] tareasProyectoNoAsignadas(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean tieneRestrasos(Integer legajo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double costoProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	





}
