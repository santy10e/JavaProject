/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class Comando {
    private String comando;
    private String fecha;

    public Comando() {
    }

    public Comando(String comando, String fecha) {
        this.comando = comando;
        this.fecha = fecha;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Comando " + comando + " se ejecuta en la fecha " + fecha;
    }
}
