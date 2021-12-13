/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.colas;

import Controlador.pilas.NodoCliente;
import Modelo.Cliente;

/**
 *
 * @author Santiago Tene
 */
public class Colas {
    private NodoCliente cabecera;
    private int tamanio;
    
    public Colas(int tamanio){
        cabecera = null;
        this.tamanio = tamanio;
    }
    
     public int tamano(){
        int tamano = 0;
         if (!estaVacia()) {
            NodoCliente tmp = cabecera;
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
    
    public void queue(Cliente dato){
        if (tamano() < this.tamanio) {
            NodoCliente temp = new NodoCliente(dato, null);
            
            if (estaVacia()) {
                temp.setSiguiente(cabecera);
                cabecera = temp;
            }else{
                NodoCliente primero = cabecera;
                NodoCliente sig = cabecera.getSiguiente();
                while (sig != null) {
                    primero = sig;
                    sig = sig.getSiguiente();
                }

                if (sig == null) {
                    primero.setSiguiente(temp);
                }
            }  
        }else{
            System.out.println("Elsta llena");
        }
    }
    
    public Cliente dequeue(){
        Cliente dato = null;
        if (!estaVacia()) {
            dato = cabecera.getDato();
            cabecera = cabecera.getSiguiente();
        }
        return dato;
    }
    
    public void mostrarLista() {
        if (!estaVacia()) {
            NodoCliente temp = cabecera;
            while (temp != null) {
                System.out.println(temp.getDato());
                temp = temp.getSiguiente();
            }
            System.out.println();
        } else {
            System.out.println("La lista esta vacia");
        }
    }
    
}
