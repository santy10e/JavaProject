package Controlador.listasimple;

import Controlador.Nodo;


public class ListaSimple {

    //Punteros para saber el inicio y el final
    protected Nodo inicio;

    public ListaSimple() {
        this.inicio = null;

    }

    //Metodo para verificar su la lista esta vacia
    public boolean estaVAcia() {
        return (this.inicio == null);

    }

    public String extraer(){
        String dato = null;
        if (!estaVAcia()) {
            dato = inicio.getDato();
            inicio = inicio.getSiguiente();
        }
        return dato;
    }
    
    //Metodo para agregar un elelemnto al inicio
    public void insertar(String dato) {
        //Se crea el nodo con el elemento e inicio
        Nodo tem = new Nodo(dato, null);
        tem.setSiguiente(inicio);
        inicio = tem;

    }

    
    
    //Metodo mostrar la lista
    public void mostrarLista() {
        if (!estaVAcia()) {
            Nodo recorrer = inicio;
            while (recorrer != null) {
                System.out.println("--" + recorrer.getDato() + "--");
                recorrer = recorrer.getSiguiente();
            }
            System.out.println();
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public String verdatoPosicio(int pos) {
        String dato=null;
        if (!estaVAcia()&&pos >=0) {
            Nodo tmp=inicio;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getSiguiente();
                if (tmp==null) 
                    break;
                
                //System.out.println(tmp.getDato());
            }
            dato = (tmp != null)? tmp.getDato() : null;
            
        }
        return dato;

    }
    //Metodo para borral un nodo al inicio de la lista.
////    public int borrarInicio() {
////        //elemento va ser igual a inicio
////        int elemento = inicio.dato;
////        //si inicio igual fin
////        //entonces ambos son nulos
////        if (inicio == fin) {
////            inicio = null;
////            fin = null;
////        //caso contraroi incio sera siguiente nodo
////        } else {
////            inicio = inicio.siguiente;
////        }
////        //se muestra el elemento que queda en la lista
////        return elemento;
////    }
////    //Metodo para borral un nodo al final de la lista.
////    public int borrarFinal() {
////        int elemento = fin.dato;
////        if (inicio == fin) {
////            inicio = null;
////            fin = null;
////        } else {
////            //se crea un nodo temporal en inicio el cual va reccorer el siguiente
////            //si este no es igual a fin entonces temporal sera el siguiente
////            Nodo temporal = inicio;
////            while (temporal.siguiente != fin) {
////                temporal = temporal.siguiente;
////            }
////            //nodo fin sera tempotal y el siguiente nulo
////            fin = temporal;
////            fin.siguiente = null;
////        }
////        return elemento;
////    }
////    public void borrarnodoEspecifico(int elemento){
////        if(!estaVAcia()){
////            if (inicio==fin && elemento == inicio.dato) {
////                inicio=fin=null;
////            }else if(elemento==inicio.dato){
////                inicio=inicio.siguiente;
////            }else{
////                Nodo anterior,temp;
////                anterior=inicio;
////                temp=inicio.siguiente;
////                while (temp!=null && temp.dato!=elemento) {
////                    anterior=anterior.siguiente;
////                    temp=temp.siguiente;
////                }if(temp!=null){
////                    anterior.siguiente=temp.siguiente;
////                    if (temp==fin) {
////                        fin=anterior;
////                    }
////                }
////            }
////        }
////    }
////    //Metodo para buscar el elemento
////    public boolean buscarElemento(int elemento){
////        Nodo temporal = inicio;
////        //mientras que incio no se igual a nulo y su datos no se igual al elemento 
////        //temporal sera siguiente elemento a buscar hasta que lo encuentre
////        while(temporal!=null && temporal.dato!=elemento){
////            temporal = temporal.siguiente;
////        }
////        //luego se retorna temporal 
////        return temporal!=null;
////    }
}
