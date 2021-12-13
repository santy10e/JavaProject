/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Nodo;

/**
 *
 * @author ASUS
 */
public class Pila {
    private Nodo cabecera;
    private int tamanio;
    
    public Pila(int tamanio){
        cabecera = null;
        this.tamanio = tamanio;
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
    
    public void push(Object dato){
        if (tamano() < this.tamanio) {
            Nodo tem = new Nodo(dato, null);
            tem.setSiguiente(cabecera);
            cabecera = tem;
        }else{
            System.out.println("Elsta llena");
        }
    }
    
    public Object pop(){
        Object dato = null;
        if (!estaVacia()) {
            dato = cabecera.getDato();
            cabecera = cabecera.getSiguiente();
        }
        return dato;
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
}
