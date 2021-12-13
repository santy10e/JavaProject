package modelo.usolista;

 // @author Santiago Tene
import java.io.Serializable;
import lista.controlador.Lista ;


public class Estudiante implements Serializable{
    private Long id;
    private Lista<DatosEstudiante> sitiosLista=new Lista();
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lista<DatosEstudiante> getSitiosLista() {
        return sitiosLista;
    }

    public void setSitiosLista(Lista<DatosEstudiante> sitiosLista) {
        this.sitiosLista = sitiosLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
