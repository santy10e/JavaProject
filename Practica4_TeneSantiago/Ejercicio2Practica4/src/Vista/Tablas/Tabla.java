/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.Colas;
import Modelo.Estudiante;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class Tabla extends AbstractTableModel{
    Colas lista = new Colas();

    public Colas getLista() {
        return lista;
    }

    public void setLista(Colas lista) {
        this.lista = lista;
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return lista.tamano();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Estudiante c =  (Estudiante)lista.obtenerPorPosicion(rowIndex);
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return c.getCedula();
            case 2: return c.getNombre();
            default: return null;
        }
    }
   
     @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "N°";
            case 1: return "Cedula";
            case 2: return "Nombre";
            default: return null;
        }
    }
}
