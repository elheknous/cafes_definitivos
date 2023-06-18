package pricipal;

import cafeteriaa.*;
import utils.GestorDatos;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Cafeteria cafeteria = crearCafeteria();
        menu(cafeteria);

    }

    private static void menu(Cafeteria cafeteria) {
        Validaciones aux = new Validaciones();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Como desea ingresar");
            System.out.println("[1] Cliente");
            System.out.println("[2] Propietario");
            System.out.println("[3] Salir");
            opcion = aux.opcionPrincipal();
            if (opcion == 1) {
                opcionCliente(cafeteria);
            } if (opcion == 2){
                opcionPropietario(cafeteria);
            }
        }while (opcion !=3);
    }

    private static void opcionPropietario(Cafeteria cafeteria) {
        Validaciones u = new Validaciones();
        int opcion = 0;
        do {
            System.out.println("[1] Añadir empleado");
            System.out.println("[2] Añadir cafe");
            System.out.println("[3] Eliminar cafe");
            System.out.println("[4] Buscar cafe (Grande/Mediano/Chico)");
            System.out.println("[5] Salir");
            opcion = u.opcionAdmi();

            switch (opcion){
                case 1:
                    cafeteria = anadirEmpleado(cafeteria);
                    break;
                case 2:
                    cafeteria = anadirCafe(cafeteria);
                    break;
                case 3:
                    cafeteria = eliminarCafe(cafeteria);
                    break;
                case 4:
                    buscarCafe(cafeteria);
                    break;
            }
        }while (opcion >= 1 && opcion <=4);
    }

    private static void buscarCafe(Cafeteria cafeteria) {
        Scanner sc = new Scanner(System.in);
        System.out.println("que cafe quiere buscar (chico,mediano,grande)");
        System.out.println("Escribalo bien porfavor :D");
        String tamano = sc.next();
        ArrayList<Cafe> cafesEncontrados = cafeteria.buscarCafe(tamano);
        imprimirCafes(cafesEncontrados);
    }

    private static Cafeteria eliminarCafe(Cafeteria cafeteria) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que cafe desea eliminar: ");
        for (int i = 0; i < cafeteria.getCafes().size(); i++) {
            System.out.println(i+1+". "+cafeteria.getCafes().get(i));
        }
        int opcion = sc.nextInt();

        cafeteria.eliminarCafe(opcion-1);
        System.out.println(cafeteria.mostrarCafes());
        return cafeteria;
    }

    private static Cafeteria anadirCafe(Cafeteria cafeteria) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Agrege un cafe: ");
        System.out.println("Gramos: ");
        String g = sc.next();
        System.out.println("Agua: ");
        String a = sc.next();
        System.out.println("Tamaño: ");
        String t = sc.next();

        cafeteria.agregarCafe(g,a,t);
        return cafeteria;

    }

    private static Cafeteria anadirEmpleado(Cafeteria cafeteria) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los datos del empleado");
        System.out.println("Nombre: ");
        String nombre = sc.next();
        System.out.println("Edad: ");
        int edad = sc.nextInt();
        System.out.println("Cargo: ");
        String cargo = sc.next();

        cafeteria.agragarEmpleado(nombre,cargo,edad);
        System.out.println("La lista de empleados actualizada es: ");
        cafeteria.mostrarEmpleado();
        return cafeteria;
    }

    private static void opcionCliente(Cafeteria cafeteria) {
        Cliente c1 = crearCliente();
        compra(cafeteria,c1);

    }

    private static void compra(Cafeteria cafeteria, Cliente c) {
        Validaciones aux = new Validaciones();
        ArrayList<Cafe> cafeComprados = new ArrayList<>();
        ArrayList<Alfajor> alfajoresComprados = new ArrayList<>();
        int num = 0;
        int opcion = 0;
        int num1 = 0;
        String frase = "Compra: \n"+"Cliente: "+c.getNombre()+"\n";
        do {
            System.out.println("Ingrese la opcion de lo que desea llevar: ");
            System.out.println("Precio cafe: 2000");
            System.out.println("Precio alfajor: 1000");
            System.out.println("-----------MENU-------------");
            num = cafeteria.mostrarCafes();
            num1 = cafeteria.mostrarAlfajores(num);
            System.out.println(num1 + ". Salir");
            opcion = aux.opcionCompras(cafeteria.getCafes().size() + cafeteria.getAlfajores().size() + 1);
            if (opcion <= cafeteria.getCafes().size()){
                cafeComprados.add(cafeteria.getCafes().get(opcion-1));
                frase = frase+ cafeteria.getCafes().get(opcion-1).registroCSV();
            }if (opcion> cafeteria.getCafes().size() && opcion <num1){
                alfajoresComprados.add(cafeteria.getAlfajores().get(opcion-cafeteria.getCafes().size()-1));
                frase += frase + cafeteria.getAlfajores().get(opcion-cafeteria.getCafes().size()-1).registroCSV();

            }

        }while (opcion < num1);
        GestorDatos g = new GestorDatos();
        g.escribirCSV(frase);

        pago(cafeteria,c,cafeComprados,alfajoresComprados);
    }

    private static void pago(Cafeteria cafeteria, Cliente c, ArrayList<Cafe> cafeComprados, ArrayList<Alfajor> alfajoresComprados) {
        int precio = 0;
        System.out.println("-------- SU CARRITO --------");
        for (int i = 0; i < cafeComprados.size(); i++) {
            System.out.println(cafeComprados.get(i).toString());
            precio = precio + cafeComprados.get(i).getPrecio();

        }
        for (int i = 0; i < alfajoresComprados.size(); i++) {
            System.out.println(alfajoresComprados.get(i).toString());
            precio = precio + alfajoresComprados.get(i).getPrecio();

        }
        if (precio > c.getDinero()){
            System.out.println("El precio final es de: "+precio);
            System.out.println("Lo sentimos, no tiene dinero suficiente");
        }else{
            System.out.println("El precio final es de: "+precio);
            System.out.println("Gracias por su compra, su nuevo saldo es de: "+(c.getDinero()-precio));
            cafeteria.setDinero(cafeteria.getDinero()+precio);
        }


    }

    private static Cliente crearCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.next();
        System.out.println("Ingrese su edad: ");
        int edad = sc.nextInt();
        System.out.println("Ingrese su saldo: ");
        int saldo = sc.nextInt();

        return new Cliente(nombre,edad,saldo);
    }

    private static Cafeteria crearCafeteria() {
        String nombre = "Los nostros";
        String direccion = "Javiera Carrera 3421";
        ArrayList<String> redes = crearRedes();
        int dinero = 100000;
        ArrayList<Cafe> cafes = crearCafes();
        ArrayList<Alfajor> alfajores = crearAlfajores();
        ArrayList<Empleado> empleados = crearEmpleados();

        return new Cafeteria(nombre,direccion,redes,dinero,cafes,alfajores,empleados);
    }

    private static ArrayList<Empleado> crearEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empleado1 = new Empleado("Jose","Jefe",20);
        Empleado empleado2 = new Empleado("Esteban","Cocinero",40);
        Empleado empleado3 = new Empleado("Juju","Cocinero",22);
        Empleado empleado4 = new Empleado("Jordan","Garzon",23);

        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        empleados.add(empleado4);

        return empleados;
    }

    private static ArrayList<Alfajor> crearAlfajores() {
        ArrayList<Alfajor> alfa = new ArrayList<>();
        Alfajor al1 =  new Alfajor("Chocolate","Chico");
        Alfajor al2 =  new Alfajor("Manjar","Grande");
        Alfajor al3 =  new Alfajor("Chocolate","Grande");

        alfa.add(al1);
        alfa.add(al2);
        alfa.add(al3);

        return alfa;
    }

    private static ArrayList<Cafe> crearCafes() {

        ArrayList<Cafe> cafes = new ArrayList<>();
        Cafe cafe1 = new Cafe("200","100","Mediano");
        Cafe cafe2 = new Cafe("150","200","Grande");
        Cafe cafe3 = new Cafe("100","50","Chico");
        Cafe cafe4 = new Cafe("50","200","Grande");

        cafes.add(cafe1);
        cafes.add(cafe2);
        cafes.add(cafe3);
        cafes.add(cafe4);

        return cafes;
    }

    private static ArrayList<String> crearRedes() {
        ArrayList<String> redes = new ArrayList<>();
        redes.add("Instagram");
        redes.add("Facebook");
        return redes;
    }
    private static void imprimirCafes(ArrayList<Cafe> cafesEncontrados) {
        for (Cafe i: cafesEncontrados){
            System.out.println(i.toString());
        }
    }
}
