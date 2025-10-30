package entidades;
public class EmpleadoDePlanta extends Empleado {
    private double valorDia;
    private String categoria; 

    public EmpleadoDePlanta(String nombre, String apellido, int legajo, int cantRetrasos,
                            boolean asignado, double valorDia, String categoria) {
        super(nombre, apellido, legajo, cantRetrasos, asignado);
        this.valorDia = valorDia;
        setCategoria(categoria); // validamos al asignar
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty())
            throw new IllegalArgumentException("La categoría no puede ser nula ni vacía.");
        // validación case-insensitive
        if (!categoria.equalsIgnoreCase("INICIAL") &&
            !categoria.equalsIgnoreCase("TECNICO") &&
            !categoria.equalsIgnoreCase("EXPERTO")) {
            throw new IllegalArgumentException("Categoría inválida: " + categoria);
        }
        this.categoria = categoria.toUpperCase(); 
    }
}
