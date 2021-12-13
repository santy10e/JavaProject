package controlador.usolista;

// @author Santiago Tene
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lista.controlador.Lista;
import modelo.usolista.Estudiante;
import modelo.usolista.DatosEstudiante;

public class EstudianteController {

    private final String CARPETA = "datos" + File.separatorChar + Estudiante.class.getSimpleName() + ".obj";
    private Lista<Estudiante> listaEstudiante = new Lista();
    private Estudiante estudiante;
    private Lista<DatosEstudiante> listDatosEstudiante = new Lista();
    private DatosEstudiante datosEstudiante;
    

    public DatosEstudiante getDatosEstudiante() {
        if (datosEstudiante == null) {
            datosEstudiante = new DatosEstudiante();
        }
        return datosEstudiante;
    }

    public Lista<DatosEstudiante> getListDatosEstudiante() {
        return listDatosEstudiante;
    }

    public void setListDatosEstudiante(Lista<DatosEstudiante> listDatosEstudiante) {
        this.listDatosEstudiante = listDatosEstudiante;
    }
    
    public void setDatosEstudiante(DatosEstudiante datosEstudiante) {
        this.datosEstudiante = datosEstudiante;
    }

    public Lista<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(Lista<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    public Estudiante getEstudiante() {
        if (estudiante == null) {
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public boolean guardar() {
        Lista<Estudiante> aux = listar();
        try {
            estudiante.setId(Long.valueOf((aux.tamanio() + 1)));
            aux.insertarNodo(estudiante);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA));
            oos.writeObject(aux);
            oos.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo guardar");
            return false;
        }
    }

    public boolean modificar() {
        Lista<Estudiante> aux = listar();
        try {
            for (int i = 0; i < aux.tamanio(); i++) {
                if (aux.consultarDatoPosicion(i).getId().intValue() == estudiante.getId().intValue()) {
                    System.out.println("get ID"+aux.consultarDatoPosicion(i).getId().intValue());
                    System.out.println("estudiante" +  estudiante.getId().intValue());
                    aux.modificarPorPos(estudiante, i);
                    guardarArchivo(aux);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo guardar");
            return false;
        }
    }
    

    private void guardarArchivo(Lista<Estudiante> aux) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA));
        oos.writeObject(aux);
        oos.close();
    }
 
    public boolean guardarSitio() {
        if (getEstudiante().getId() != null) {
            datosEstudiante.setId(estudiante.getId());
            estudiante.getSitiosLista().insertarNodo(datosEstudiante);
            Lista<Estudiante> aux = listar();
            int pos = -1;
            for (int i = 0; i < aux.tamanio(); i++) {
                if (aux.consultarDatoPosicion(i).getId().intValue() == estudiante.getId().intValue()) {
//                    aux.consultarDatoPosicion(i).setSitiosLista(estudiante.getSitiosLista());
                    pos = i;
                    break;
                }
            }
            System.out.println("Posicion" + pos);
            if (pos >= 0) {
                try {
                    aux.modificarPorPos(getEstudiante(), pos);
                    guardarArchivo(aux);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return true;
        } else {
            return false;
        }
    }

    public Lista<Estudiante> listar() {
        Lista<Estudiante> lista = new Lista<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA));
            lista = (Lista<Estudiante>) ois.readObject();
            ois.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
        return lista;

    }

}
