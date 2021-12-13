/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Santiago Tene
 */
public class Cliente {
    private Integer id;
    private String nombres;
    private String cedula;
    private String direccion;

    public Cliente(Integer id, String nombres, String cedula, String direccion) {
        this.id = id;
        this.nombres = nombres;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombres + " " + cedula + " " + direccion + "\t";
    }
}
