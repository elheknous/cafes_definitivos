package cafeteriaa;

import java.util.ArrayList;

public class Cafeteria {
    private String nombre;
    private String direccion;
    private ArrayList<String> redesSocioales;
    private int dinero;
    private ArrayList<Cafe> cafes;
    private ArrayList<Alfajor> alfajores;
    private ArrayList<Empleado> empleados;

    public Cafeteria(String nombre, String direccion, ArrayList<String> redesSocioales, int dinero, ArrayList<Cafe> cafes, ArrayList<Alfajor> alfajores, ArrayList<Empleado> empleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.redesSocioales = redesSocioales;
        this.dinero = dinero;
        this.cafes = cafes;
        this.alfajores = alfajores;
        this.empleados = empleados;
    }



    public void agregarCafe(String g, String a, String t){
        this.cafes.add(new Cafe(g,a,t));
    }

    public ArrayList<Cafe> getCafes() {
        return cafes;
    }

    public ArrayList<Alfajor> getAlfajores() {
        return alfajores;
    }

    public int mostrarCafes(){
        System.out.println("CAFES");
        int num = 0;
        for (int i = 0; i < cafes.size(); i++) {
            System.out.println((1+i)+". "+cafes.get(i));
            num++;
        }
        return num+1;
    }

    public void agragarEmpleado(String n, String c, int e){
        this.empleados.add(new Empleado(n,c,e));
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getDinero() {
        return dinero;
    }

    public int mostrarAlfajores(int num){
        System.out.println("ALFAJORES");
        int n = num;
        for (int i = 0; i < alfajores.size(); i++) {
            System.out.println((num+i)+". "+alfajores.get(i));
            n++;
        }
        return n;
    }
    public void eliminarCafe(int n){
        this.cafes.remove(n);
    }
    public ArrayList<Cafe> buscarCafe(String tamano){
        ArrayList<Cafe> elementos = new ArrayList<>();
        for (int i = 0; i < cafes.size(); i++) {
            if (tamano.equals(cafes.get(i).getTamano())){
                elementos.add(cafes.get(i));
            }
        }
        return elementos;

    }
    public void mostrarEmpleado(){
        for (int j = 0; j <empleados.size(); j++) {
            System.out.println("Nombre: "+empleados.get(j).getNombre());
            System.out.println("Edad: "+empleados.get(j).getEdad());
            System.out.println("Cargo: "+empleados.get(j).getCargo());
            System.out.println(" ");
        }
    }


    @Override
    public String toString() {
        return "cafeteriaa.Cafeteria{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", redesSocioales=" + redesSocioales +
                ", dinero=" + dinero +
                ", cafes=" + cafes +
                ", alfajores=" + alfajores +
                ", empleados=" + empleados +
                '}';
    }
}


