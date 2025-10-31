package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	private Integer contadorIdProyecto = 1; 
	private Queue<Empleado>empleadosDisponibles;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //lo usamos para pasar fechas de String a LocalDate
	
	
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
            throw new IllegalArgumentException("Faltan datos o son inválidos");
        }        
        int legajo = contadorLegajos++;
        
        EmpleadoContratado nuevo = new EmpleadoContratado(
        	    nombre, legajo,0,false, valor
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
	    EmpleadoDePlanta e = new EmpleadoDePlanta(nombre, legajo, 0, false, valor, categoria);
	    e.setLegajo(legajo);
	    empleados.put(legajo, e);
	}
	//prueba
	public void listarEmpleados() {
	    for (Empleado e : empleados.values()) {
	        System.out.println("Legajo: " + e.getLegajo() + " | Nombre: " + e.getNombre());
	    }
	}
	/**
     * Registra un nuevo proyecto en el sistema.
     *
     * @param titulos Títulos de las tareas del proyecto.
     * @param descripcion Descripciones de cada tarea.
     * @param dias Días estimados de duración de cada tarea.
     * @param domicilio Domicilio donde se desarrollará el proyecto.
     * @param cliente Datos del cliente (nombre, mail, teléfono).
     * @param inicio Fecha de inicio del proyecto (formato YYYY-MM-DD).
     * @param fin Fecha de finalización estimada (formato YYYY-MM-DD).
     * @throws IllegalArgumentException Si los datos son inconsistentes o faltan.
     */
	
	@Override
	public void registrarProyecto(String[] tituloTarea, String[] descripTarea, double[] duracionTarea, 
			String domicilio, String[] cliente, String fechaInicio, String fechaFin) {
		if (cliente == null || cliente.length == 0   || domicilio == null || domicilio.isEmpty() )
	        throw new IllegalArgumentException("Faltan datos para crear un Proyecto");  
		if( tituloTarea == null || tituloTarea.length == 0 )
			throw new IllegalArgumentException("Agregar tareas para crear un Proyecto");
		
        LocalDate fecha1 = LocalDate.parse(fechaInicio, formatter);
        LocalDate fecha2 = LocalDate.parse(fechaFin, formatter);
		
		if( fecha1.isAfter(fecha2)) //  isAfter es metodo de LocalDate
			throw new IllegalArgumentException("La fecha de finalización no puede ser anterior al inicio");
		
		Integer id =contadorIdProyecto ++;
		Proyecto nuevo = new Proyecto(tituloTarea, descripTarea, duracionTarea, 
				domicilio, cliente, fechaInicio, fechaFin );
		nuevo.setId(id);
		proyectos.put(id, nuevo);			
	}	

	/**
     * Asigna un empleado responsable a una tarea específica dentro de un proyecto.     *
     * @param numero Número o código del proyecto.
     * @param titulo Título de la tarea a asignar.
     * @throws Exception si intenta asignar a una tarea ya asignada o el proyecto esta finalizado
     */
	@Override
	public void asignarResponsableEnTarea(Integer idProyecto, String titulo) throws Exception {		
		Proyecto proyecto = proyectos.get(idProyecto);
	    if (proyecto == null) {
	        throw new IllegalArgumentException("No existe un proyecto con esa identificación");
	    }	    
	    if (proyecto.estaFinalizado()) {
	        throw new Exception("El proyecto ya está finalizado");
	    }
	    Tarea tarea = proyecto.getTareaPorTitulo(titulo);
	    if (tarea == null) {
	        throw new IllegalArgumentException("No existe una tarea con ese título en el proyecto");
	    }
	    // si la tarea ya tiene un empleado asignado
	    if (tarea.getEmpleado() != null) {
	        throw new Exception("La tarea ya tiene un empleado asignado");
	    }
	    
	    Empleado empleado = seleccionarEmpleadoDisponible(); 
	    
	    //asignar el empleado obtenido
	    tarea.setEmpleado(empleado);
	}
	private Empleado seleccionarEmpleadoDisponible() {  //selección FIFO
		Empleado primeroDeLaCola = empleadosDisponibles.peek(); // es retornado y eliminado de la cola
		return primeroDeLaCola;
	}
	
	/**
     * Asigna a la tarea el empleado con menos retrasos acumulados.
     * @param numero Número o código del proyecto.
     * @param titulo Título de la tarea.
     *@throws Exception si no hay empleados disponibles o la tarea ya fue asignada o el proyecto esta finalizado
     */
	@Override
	public void asignarResponsableMenosRetraso(Integer idProyecto, String titulo)throws Exception {
		
		Proyecto proyecto = proyectos.get(idProyecto);
	    if (proyecto == null)
	        throw new IllegalArgumentException("No existe un proyecto con esa identificación");
	  	    
	    if (proyecto.estaFinalizado()) 
	        throw new Exception("El proyecto ya está finalizado");
	    
	    Tarea tarea = proyecto.getTareaPorTitulo(titulo);
	    if (tarea == null) 
	        throw new IllegalArgumentException("No existe una tarea con ese título en el proyecto");	    
			
		if(tarea.getEmpleado() != null) 
			throw new Exception("La tarea y tiene un empleado asignado");
		
		Empleado empleadoSeleccionado = null;
	    for (Empleado e : empleados.values()) {
	        if (!e.isAsignado()) { 
	            if (empleadoSeleccionado == null || e.getCantRetrasos() < empleadoSeleccionado.getCantRetrasos()) {
	                empleadoSeleccionado = e;
	            }
	        }
	    }
	    //si después de buscar, no hay empleados disponibles:
	    if (empleadoSeleccionado == null) {
	        throw new Exception("No hay empleados disponibles");
	    }
	    
	    tarea.setEmpleado(empleadoSeleccionado);
	    empleadoSeleccionado.setAsignado(true);
		
	}
	
	@Override
	public void finalizarProyecto(Integer consultarSeleccionado, String fecha) {
		// TODO Auto-generated method stub
		
	}
	 /**
   * Reasigna un empleado a una tarea determinada dentro de un proyecto.
   * Libera al empleado anterior.
   * @param numero Número o código del proyecto.
   * @param legajo Legajo del empleado a reasignar.
   * @param titulo Título de la tarea.
   * @throw  Exception si no hay empleados disponibles o si no tiene asignado un empleado previamente
   */
	
	@Override
	public void reasignarEmpleadoEnProyecto(Integer consultarSeleccionado, Integer legajo, String titulo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reasignarEmpleadoConMenosRetraso(Integer consultarSeleccionado, String titulo) {
		// TODO Auto-generated method stub
		
	}
	
	public double costoProyecto() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public List<Tupla<Integer, String>> proyectosFinalizados() {
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
	@Override
	public Object[] empleadosNoAsignados() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean estaFinalizado(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int consultarCantidadRetrasosEmpleado(Integer legajo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Tupla<Integer, String>> empleadosAsignadosAProyecto(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object[] tareasProyectoNoAsignadas(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	public Object[] tareasDeUnProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String consultarDomicilioProyecto(Integer consultarSeleccionado) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean tieneRestrasos(Integer legajo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Tupla<Integer, String>> empleados() {
		// TODO Auto-generated method stub
		return null;
	}
   
	public String consultarProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return null;
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
	public double costoProyecto(Integer numero) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	





}
