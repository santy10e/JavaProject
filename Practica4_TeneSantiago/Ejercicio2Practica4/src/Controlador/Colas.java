/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.Nodo;
/**
 *
 * @author ASUS
 */
public class Colas {
    private Nodo cabecera;
    private int tamanio;
    
    public Colas(int tamanio){
        cabecera = null;
        this.tamanio = tamanio;
    }

    public Nodo getCabecera() {
        return cabecera;
    }

    public void setCabecera(Nodo cabecera) {
        this.cabecera = cabecera;
    }

    public Colas() {
        cabecera = null;
    }
    
     public int tamano(){
        int tamano = 0;
         if (!estaVacia()) {
            Nodo tmp = cabecera;
            while (tmp != null) {
                tamano++;
                tmp = tmp.getSiguiente();
            }
         }
        return tamano;
    }
    
    public boolean estaVacia() {
        return (this.cabecera == null);

    }
    
    public void queue(String cedula, String nombre){
        if (tamano() >= this.tamanio) {
            dequeue();
        }
        
        Nodo temp = new Nodo(new Estudiante(cedula,nombre), null);
        if (estaVacia()) {
            temp.setSiguiente(cabecera);
            cabecera = temp;
        }else{
            Nodo primero = cabecera;
            Nodo sig = cabecera.getSiguiente();
            while (sig != null) {
                primero = sig;
                sig = sig.getSiguiente();
            }

            if (sig == null) {
                primero.setSiguiente(temp);
            }
        } 
    }
    
    public Object dequeue(){
        Object dato = null;
        if (!estaVacia()) {
            dato = cabecera.getDato();
            cabecera = cabecera.getSiguiente();
        }
        return dato;
    }
    
    //Se ocupo el metodo mostrar lista de la cola para invertir la cola
    public void invertir(Nodo aux){
            Nodo ant = null;
            ant = aux.getSiguiente();
            aux.setSiguiente(ant.getSiguiente());
            ant.setSiguiente(this.cabecera);
            this.cabecera = ant;
            if(aux.getSiguiente() == null){
                return;
            }else{
                invertir(aux);
            }   
  
    }
    
    public void mostrarLista() {
        if (!estaVacia()) {
            Nodo temp = cabecera;
            while (temp != null) {
                System.out.println(temp.getDato().toString());
                temp = temp.getSiguiente();
            }
            System.out.println();
        } else {
            System.out.println("La lista esta vacia");
        }
    }
    
    public Object obtenerPorPosicion(int pos){
        Object dato = null;
        if (!estaVacia() && pos >=0 && (pos <= tamano()-1)){
            Nodo temp = cabecera;
            for (int i = 0; i < pos; i++) {
                temp = temp.getSiguiente();
                if (temp.getSiguiente() == null) 
                    break;
            } 
            dato = temp.getDato();
        }else{
            if (pos < 0 || (pos > tamano() -1)) {
                throw new IndexOutOfBoundsException("Fuera de rango");
            }
        }
        return dato;
    }
}
