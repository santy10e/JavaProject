/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Santiago Tene
 */
public class Nodo {
    public String dato;
    public Nodo siguiente;
    // Constructor para insertar al final
    public Nodo() {
        this.dato = null;
        this.siguiente=null;
    }
    //Constructor para Insertar al inicio
    public Nodo(String dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }


    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    

}
