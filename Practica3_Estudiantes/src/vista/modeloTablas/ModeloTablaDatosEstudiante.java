package vista.modeloTablas;

import javax.swing.table.AbstractTableModel;
import lista.controlador.Lista;
import modelo.usolista.Estudiante;
import modelo.usolista.DatosEstudiante;

/**
 *
 * @author Santiago Tene
 */
public class ModeloTablaDatosEstudiante extends AbstractTableModel {

    private Lista<Estudiante> lista = new Lista();
    private Lista<DatosEstudiante> listado = new Lista<>();

    public Lista<DatosEstudiante> getListado() {
        return listado;
    }

    public void setListado(Lista<DatosEstudiante> listado) {
        this.listado = listado;
    }

    public Lista<Estudiante> getLista() {
        
        return lista;
    }

    private void listaMaterias() {
        listado = new Lista<>();
        for (int j = 0; j < lista.tamanio(); j++) {
            Estudiante c = lista.consultarDatoPosicion(j);
            for (int i = 0; i < c.getSitiosLista().tamanio(); i++) {
                listado.insertarNodo(c.getSitiosLista().consultarDatoPosicion(i));
            }
        }
        System.out.println(listado.tamanio()+"OK");
    }

    public void setLista(Lista lista) {
        this.lista = lista;
        listaMaterias();
    }

    @Override
    public int getRowCount() {
        return listado.tamanio();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        DatosEstudiante datEstud = listado.consultarDatoPosicion(i);
        switch (i1) {
            case 0:
                return datEstud.getNombre();
            case 1:
                return datEstud.getApellido();
            case 2:
                return datEstud.getCedula();
            case 3:
                return datEstud.getCorreo();
            case 4:
                return datEstud.getCiclo();
            case 5:
                return datEstud.getNota();
            case 6:
                return lista.consultarDatoPosicion(datEstud.getId().intValue()-1).getNombre();
            case 7:
                return datEstud.getObservaciones();
            default: 
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellido";
            case 2:
                return "Cedula";
            case 3:
                return "Correo";
            case 4:
                return "Ciclo";
            case 5:
                return "Nota";
            case 6:
                return "Materia";
            case 7:
                return "Observaciones";
            default:
                return null;
        }
    }

}
