/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.colas.Colas;

/**
 *
 * @author Santiago Tene
 */
public class ejecutorColas {
    public static void main(String[] args) {
        Colas c = new Colas(3);
        Cliente cl1 = new Cliente(c.tamano() + 1, "Jose", "0912831", "Loja");
        c.queue(cl1);
        Cliente cl2 = new Cliente(c.tamano() + 1, "Anita", "0912312", "Loja");
        c.queue(cl2);
        Cliente cl3 = new Cliente(c.tamano() + 1, "Pepe", "09123812", "Loja");
        c.queue(cl3);
        c.mostrarLista();
        System.out.println("******************");
        c.dequeue();
        c.mostrarLista();
        System.out.println("******************");
    }
}
