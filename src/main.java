/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author Pc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int nodo_info = 0;
        int num = 0;
        Cola cola = new Cola();

        do {
            System.out.println("Menu: \n\n"
                    + "1. Insertar nodo \n"
                    + "2. Extraer un nodo\n"
                    + "3. Mostrar contenido de la cola\n"
                    + "4. Salir. \n"
                    + "Ingrese una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    num++;
                    System.out.println("Llego un nuevo cliente");
                    cola.Insertar(num);
                    break;
                case 2:
                    if (!cola.ColaVacia()) {
                        cola.Extraer(num);
                    } else {
                        System.out.println("La cola esta vacia");
                    }
                    break;
                case 3:
                    cola.Mostrar();
                    break;
                case 4:
                    System.out.println("Hasta luego !");
                    break;
            }
        } while (opcion != 4);

    }

}
