import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private int edad;
    private int dinero;



    public Cliente(String nombre, int edad, int dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }


    public int getDinero() {
        return dinero;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dinero=" + dinero +
                    '}';
    }
}
