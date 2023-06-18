package cafeteriaa;

public class Empleado {
    private String nombre;
    private String cargo;
    private int edad;

    public Empleado(String nombre, String cargo, int edad) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "cafeteriaa.Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", edad=" + edad +
                '}';
    }

    public int getEdad() {
        return edad;
    }
}
