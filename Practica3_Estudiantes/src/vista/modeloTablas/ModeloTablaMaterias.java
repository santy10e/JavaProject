package vista.modeloTablas;


import javax.swing.table.AbstractTableModel;
import lista.controlador.Lista;
import modelo.usolista.Estudiante;

/**
 *
 * @author Santiago Tene
 */
public class ModeloTablaMaterias extends AbstractTableModel{
    
    private Lista<Estudiante> lista=new Lista();

    public Lista<Estudiante> getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.tamanio();
    }

   

    @Override
    public Object getValueAt(int i, int i1) {
        Estudiante dato = lista.consultarDatoPosicion(i);
            switch(i1){    
                case 0: return dato.getNombre();
                case 1: return dato.getSitiosLista().tamanio();
                
                default:return null;
            }
   
    }

     @Override
    public int getColumnCount() {
        return 2;
        
    }


    @Override
    public String getColumnName(int i) {
         switch(i){    
                case 0: return "Materias";
                case 1: return "Nro de Estudiantes";
                
                default:return null;
            }
    }
    
}
