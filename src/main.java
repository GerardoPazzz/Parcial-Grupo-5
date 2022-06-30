import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {

        int opcion, num = 0;
        Cola cola = new Cola();

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                  "         Cine Madrid\n\n"
                + "1. Nuevo cliente\n"
                + "2. Atender cliente\n"
                + "3. Mostrar clientes restantes\n"
                + "4. Cerrar\n"
                + "5. Salir \n\n"
                + "Ingrese una opcion: "));
            switch(opcion){
                case 1:
                    num = 1 + (int)(Math.random()*99);
                    JOptionPane.showMessageDialog(null, "Llego un nuevo cliente. Codigo: "+num);
                    cola.Insertar(num);
                    break;
                case 2:
                    double total = 0;
                    if (!cola.ColaVacia()) {
                       String nombre = JOptionPane.showInputDialog(null, "Introducir nombre: ");
                       int sala = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Cartelera\n\n"
                                    + "1. Gemelo Siniestro\n"
                                    + "2. Lightyear\n"
                                    + "3. Minions: Nace un villano\n"
                                    + "4. El Buen Patron\n"
                                    + "5. Desastre Inminente\n"
                                    + "Ingrese una opcion: "));
                       int nroAsientos = Integer.parseInt(JOptionPane.showInputDialog(null,"Introducir nro de asientos"));
                       total += nroAsientos * 14.50;
                       int combo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Comida\n\n"
                                    + "Combo 1: 1 Cancha mediana + Gaseosa mediana\n"
                                    + "Combo 2: 1 Cancha grande + 2 Gaseosas medianas\n"
                                    + "Combo 3: 1 Cancha gigante + 3 Gaseosas medianas\n"
                                    + "Combo 4: 1 Cancha mediana + Nachos + 1 Gaseosa mediana\n"
                                    + "Combo 5: 1 Cancha grande + Nachos + 2 Gaseosa grandes\n"
                                    + "Ingrese combo: "));
                       total += 10.00 + combo * 4.50;
                       Nodo nodoAux= cola.Extraer(nombre, nroAsientos, sala, combo, total);
                       Boleta(nodoAux);
                    } else {
                        JOptionPane.showMessageDialog(null, "La cola esta vacia!");
                    }
                        break;
                case 3:
                    cola.Mostrar();
                    break;
                case 4:
                    cola.Eliminar();
                    JOptionPane.showMessageDialog(null, "Cine CERRADO, vuelva pronto!");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion NO disponible!");
                    break;
            }
        } while(opcion != 5);
    }
    
    static void Boleta(Nodo nodo){
        double totalAsientos = nodo.num_asientos * 14.50;
        double totalCombo = nodo.combo * 4.50 + 10.00;
        JOptionPane.showMessageDialog(null,
                  "         Cine Madrid \n"
                + "\nCliente N°" + nodo.num_orden 
                + "\nNombre: " + nodo.nombre
                + "\nSala N°" + nodo.sala
                + "\nNro de asientos: " + nodo.num_asientos
                + "\nTotal en asientos: " + totalAsientos
                + "\nCombo pedido: " + nodo.combo
                + "\nTotal en Combo: " + totalCombo
                + "\nMonto Total: " + nodo.monto
        );
    }
}