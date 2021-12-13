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
public class ejecutorPilas {
    public static void main(String[] args) {
        Pila p = new Pila(4);
        Cliente cl1 = new Cliente(p.tamano() + 1, "Juan", "5421321", "Loja");
        p.push(cl1);
        Cliente cl2 = new Cliente(p.tamano() + 1, "Andres", "21200312", "Loja");
        p.push(cl2);
        Cliente cl3 = new Cliente(p.tamano() + 1, "Pablo", "1102341", "Loja");
        p.push(cl3);
        Cliente cl4 = new Cliente(p.tamano() + 1, "Carmita", "23123124", "Loja");
        p.push(cl4);
        p.mostrarLista();
        System.out.println("-------------");
        System.out.println(p.pop());
        p.push(new Cliente(p.tamano() + 1, "Sebastian", "3423423", "Loja"));
        System.out.println("-------------");
        p.mostrarLista();
    }
}
