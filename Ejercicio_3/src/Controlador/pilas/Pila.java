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
public class Pila {
    private NodoCliente cabecera;
    private int tamanio;
    
    public Pila(int tamanio){
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
    
    public void push(Cliente dato){
        if (tamano() < this.tamanio) {
            if (!existeCliente(dato.getCedula())) {
                NodoCliente tem = new NodoCliente(dato, null);
                tem.setSiguiente(cabecera);
                cabecera = tem;
            }else{
                System.out.println("Ya existe un cliente con ese numero de cedula");
            }
        }else{
            System.out.println("Elsta llena");
        }
    }
    
    public Cliente pop(){
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
    //No es parte de la pila
    public Boolean existeCliente(String cedula) {
        Boolean existe = false;
        if (!estaVacia()) {
            NodoCliente tmp = cabecera;
            while (tmp != null) {
                if (tmp.getDato().getCedula().equals(cedula)) {
                    existe = true;
                    break;
                }
                tmp = tmp.getSiguiente();
            }
        }
        return existe;
    }
}
