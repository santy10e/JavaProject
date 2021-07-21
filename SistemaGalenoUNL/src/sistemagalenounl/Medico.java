package sistemagalenounl;
//@author santy 

public class Medico extends Persona {

    private String especialidad;

    public Medico(String nombre, String especialidad, String cedula) {
        this.especialidad = especialidad;
        super.setNombre(nombre);
        super.setCedula(cedula);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
