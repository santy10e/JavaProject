package estructurasdinamicas;

import lista.controlador.Lista;

/**
 *
 * @author Santiago Tene
 */
public class EstructurasDinamicas {
    // @param args the command line arguments

    public static void main(String[] args) {
        Lista lista = new Lista();
        System.out.println("Esta bacia " + lista.estaVacia());
        lista.insertarNodo("casa");
        lista.imprimir();
        lista.insertarNodo("perro");
        System.out.println("*******************");
        lista.imprimir();
        lista.insertarNodo("gato");
        System.out.println("******************");
        lista.imprimir();
        System.out.println("Esta vacia " + lista.tamanio());

        System.out.println("Esta vacia" + lista.tamanio());
        lista.imprimir();
        System.out.println(((lista.consultarDatoPosicion(1) != null) ? "Hay dato" : "no hay dato"));
//        lista.insertar("colibri",3);
//        lista.insertarNodo("Colibri");
        System.out.println("//////////");
        lista.imprimir();
        System.out.println("IMPRIMIR");
        lista.modificarPorPos("gatitos", -1);
        lista.imprimir();

    }

}
