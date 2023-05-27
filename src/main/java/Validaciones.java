import java.util.InputMismatchException;
import java.util.Scanner;

public class Validaciones {

    public int opcionPrincipal() {
        boolean error;
        int u = 0;
        do {
            try {
                error = false;
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese un numero: ");
                u = sc.nextInt();
                if (u < 1 || u > 3){
                    System.err.println("Error, intente de nuevo");
                    error = true;
                }
            }catch (InputMismatchException e){
                System.err.println("Error, intente de nuevo");
                error = true;
            }
        }while (error);
        return u;
    }
    public int opcionCompras(int n) {
        boolean error;
        int u = 0;
        do {
            try {
                error = false;
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese un numero: ");
                u = sc.nextInt();
                if (u < 1 || u > n){
                    System.err.println("Error, intente de nuevo");
                    error = true;
                }
            }catch (InputMismatchException e){
                System.err.println("Error, intente de nuevo");
                error = true;
            }
        }while (error);
        return u;
    }
    public int opcionAdmi() {
        boolean error;
        int u = 0;
        do {
            try {
                error = false;
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese un numero: ");
                u = sc.nextInt();
                if (u < 1 || u > 5){
                    System.err.println("Error, intente de nuevo");
                    error = true;
                }
            }catch (InputMismatchException e){
                System.err.println("Error, intente de nuevo");
                error = true;
            }
        }while (error);
        return u;
    }

}
