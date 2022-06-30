
import javax.swing.JOptionPane;

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

    public void Insertar(int num) {
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.num_orden = num;
        nuevo_nodo.siguiente = null;

        if (ColaVacia() == true) {
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        } else {
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }
    }

    public Nodo Extraer(String nombre, int num_asientos, int sala, int combo, double monto) {
        if (!ColaVacia()) {
            inicioCola.nombre = nombre;
            inicioCola.num_asientos = num_asientos;
            inicioCola.sala = sala;
            inicioCola.combo = combo;
            inicioCola.monto = monto;
            Nodo nodo_retirado = inicioCola;
            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.siguiente;
            }
            return nodo_retirado;
        } else {
            return null;
        }
    }

    public void Mostrar() {
        Nodo recorrido = inicioCola;
        String ColaInvertida = "";

        while (recorrido != null) {
            Cola += recorrido.num_orden + " ";
            recorrido = recorrido.siguiente;
        }

        String cad[] = Cola.split(" "); //es para invertir 

        for (int i = cad.length - 1; i >= 0; i--) { // -1 es para evitar un desbordamiento de memoria
            ColaInvertida += " " + cad[i]; //para que no se amontonen los datos
        }
        JOptionPane.showMessageDialog(null, ColaInvertida);
        Cola = "";
    }

    public void Eliminar() {
        if (!ColaVacia()) {
            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.siguiente;
                Eliminar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La cola esta vacia!");
        }
    }
}
