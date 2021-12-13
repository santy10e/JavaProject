/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.pilas;

import Modelo.Cliente;

/**
 *
 * @author Santiago Tene
 */
public class NodoCliente {
     public Cliente dato;
    public NodoCliente siguiente;
    // Constructor para insertar al final
    public NodoCliente() {
        this.dato = null;
        this.siguiente=null;
    }
    //Constructor para Insertar al inicio
    public NodoCliente(Cliente dato, NodoCliente siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }
    
}
