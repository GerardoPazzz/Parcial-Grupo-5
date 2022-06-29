/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc
 */
public class Cola {
    private Nodo inicioCola;
    private Nodo finalCola;
    String Cola = "";

    public Cola() {
        inicioCola = null;
        finalCola = null;
    }

    public boolean ColaVacia() {
        if (inicioCola == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Insertar(int info) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.info = info;
        nuevo_nodo.siguiente = null;

        if (ColaVacia() == true) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }
    }

    public int Extraer() {
        if (!ColaVacia()) {
            int informacion = inicioCola.info;
            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.siguiente;
            }
            return informacion;
        } else {
            return 0;
        }
    }

    public void Mostrar() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            Cola += recorrido.info + " ";
            recorrido = recorrido.siguiente;
        }

        String cad[] = Cola.split(" "); //es para invertir 

        for (int i = cad.length - 1; i >= 0; i--) { // -1 es para evitar un desbordamiento de memoria
            ColaInvertida += " " + cad[i]; //para que no se amontonen los datos
        }
        System.out.println(ColaInvertida);
        Cola = "";
    }

}
